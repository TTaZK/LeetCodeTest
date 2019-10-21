package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Permutation_in_String_567 {
    // Solution-1
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        // init
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Integer v = map.get(s1.charAt(i));
            if (v == null) {
                map.put(s1.charAt(i), 1);
            } else {
                map.put(s1.charAt(i), v + 1);
            }
        }

        // iterator
        int start = 0;
        int end = 0;
        int counter = s1.length();
        while (end < s2.length()) {
            Character c = s2.charAt(end);
            Integer count = map.get(c);
            if (count == null) {
                end++;
                start = end;
                counter = s1.length();
                // 需要对map重新初始化
                // re-init
                continue;
            }
            if (count > 0) {
                map.put(c, count - 1);
                counter--;
                end++;
            } else {
                // map.get(start) cannot be null
                while (map.get(s2.charAt(start)) <= 0) {
                    map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                    start++;
                    counter++;
                }
            }

        }
        if (end - start + 1 == s2.length()) return true;
        return false;
    }

    // Solution-2
    // use two hash map
    // faster than 22.93% ....
    public static boolean checkInclusion_1(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        // init
        Map<Character, Integer> map_s1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map_s1.merge(s1.charAt(i), 1, Integer::sum);
        }
        // iterator
        Map<Character, Integer> map_s2 = new HashMap<>();
        int start, end;
        start = end = 0;
        for (; end < s1.length() - 1; end++) {
            map_s2.merge(s2.charAt(end), 1, Integer::sum);
        }

        // iterator
        while (end < s2.length()) {
            map_s2.merge(s2.charAt(end), 1, Integer::sum);
            if (equal(map_s1, map_s2)) {
                return true;
            }
            map_s2.merge(s2.charAt(start), -1, Integer::sum);
            end++;
            start++;
        }

        return false;
    }

    public static boolean equal(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    // Solution-3
    // use array(int[]) rather than hash map
    public static boolean checkInclusion_2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        return true;
    }


    public static void main(String[] args) {
        System.out.println(checkInclusion_1("ab", "eidboaooo"));
    }
}
