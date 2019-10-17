package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement_424 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n == 0) return 0
        // Used to save the number of occurrences of each character
        // char -> count
        Map<Character, Integer> counter = new HashMap<>();
        // If the current substring does not meet the requirements, start will move right the shrink window
        int start = 0;
        // Used to expend the window until the window is not satisfied
        int end = 0;
        // Used to store cur max character num
        int maxCount = 0;
        // Ans
        int result = 0;

        while (end < n) {

            end++;
        }

    }
}
