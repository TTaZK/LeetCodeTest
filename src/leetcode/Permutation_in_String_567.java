package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Permutation_in_String_567 {
    public boolean checkInclusion(String s1, String s2) {
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
        while (end < s2.length()) {
            Character c = s2.charAt(end);
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
            }else {

            }
        }
    }
}
