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
        System.out.println(isContain("acccb", "abc"));
        System.out.println("ni".substring(0, 0).length());
        System.out.println(minWindow("ADOBECODEBANCB", "BANC"));
    }
}
