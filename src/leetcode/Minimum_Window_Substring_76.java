package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Window_Substring_76 {
    // 设置left，right两个指针
    // 如果string[left,right]之间的字串不能包含t，则right右移
    // 如果包含，则记录此时的字串；然后left右移，如果仍然包含，则继续右移，直到不能包含t，并更新字串
    // 再将right继续右移，重复之前的步骤
    // 该实现方法在遇到s非常大的情况下，造成了超时（test case最后一个没过。。。）
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int n = s.length();
        int left = 0;
        int right = 0;
        List<String> res = new ArrayList<>(1);
        while (right <= n) {
            String sub = s.substring(left, right);
            if (isContain(sub, t)) {
                if (res.size() == 0) {
                    res.add(sub);
                } else {
                    String str = res.remove(0);
                    String temp = sub.length() < str.length() ? sub : str;
                    res.add(temp);
                }
                left++;
            } else {
                right++;
            }
        }
        return res.size() == 0 ? "" : res.get(0);
    }

    public static boolean isContain(String src, String dest) {
        if (src.length() < dest.length()) return false;
        Map<Character, Integer> srcMap = new HashMap<>();
        for (char c : src.toCharArray()) {
            Integer value = srcMap.get(c);
            if (value == null) {
                srcMap.put(c, 1);
            } else {
                srcMap.put(c, value + 1);
            }
        }
        for (char c : dest.toCharArray()) {
            Integer value = srcMap.get(c);
            if (value == null || value == 0) return false;
            srcMap.put(c, value - 1);
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isContain("acccb", "abc"));
//        System.out.println("ni".substring(0, 0).length());
//        System.out.println(minWindow("ADOBECODEBANCB", "BANC"));
        solution("ADOBECODEBANC",
                "ABC");
    }

    // 参考网上讨论
    public static String solution(String s, String t) {
        if (s.length() < t.length()) return "";
        int counter = t.length();
        int start, end, size, minStart, minLength;
        start = end = minStart = 0;
        size = s.length();
        minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        // init
        for (Character c : t.toCharArray()) {
            Integer value = map.get(c);
            if (value == null) {
                map.putIfAbsent(c, 1);
            } else {
                map.put(c, value + 1);
            }
        }
        // find valid substring
        while (end < size) {
            Character c = s.charAt(end);
            Integer value = map.get(c);
            if (value != null) {
                if (value > 0) {
                    counter--;
                }
                // find a char that t exists
                int v = value;
                map.put(c, --v);
            }
            if (value == null || value == 0) {
                map.put(c, -1);
            }
            end++;
            // valid substring
            while (counter == 0) {
                // 此时map中各个char对应的值就是：当前位置之前s中该元素的数量比t中多的数目
                int curLength = end - start;
                if (curLength < minLength) {
                    minLength = curLength;
                    minStart = start;
                }
                // minify window
                char ch = s.charAt(start);
                Integer vl = map.get(ch);
                map.put(ch, ++vl);

                if (vl > 0) {
                    counter++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
