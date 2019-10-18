package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Longest_Repeating_Character_Replacement_424 {
    // end指针用于扩大窗口，start指针用于缩小窗口
    // 在由start->end组成的子串中，如果（子串的长度 - 出现次数最多的字符的数目 <= k）
    // 那么在这个子串中进行 <= k 次转换操作就可以将该子串全部转换为 出现次数最多的字符
    // 此时称为当前窗口为有效窗口
    // 如果窗口无效了，即 (子串的长度 - 出现次数最多的字符的数目 > k），那么需要缩小窗口直到变成有效窗口
    // start指针右移，然后更新各个字符在子串中出现的次数，并同时更新 出现次数最多的字符的数目
    // ps: 在统计子串中出现次数最多的字符数目时，并不关心是哪个字符

    // 延伸问题：给定字符串s,最少需要多少次操作能将该字符串中的字符变成同一个字符
    // ans: 先统计出现次数最多的字符数目 x ，则最少次数为 s.length() - x

    // The problem says that we can make at most k changes to the string (any character can be replaced with any other character).
    // So, let's say there were no constraints like the k. Given a string convert it to a string with all same characters with minimal changes.
    // The answer to this is
    //      length of the entire string - number of times of the maximum occurring character in the string
    //Given this, we can apply the at most k changes constraint and maintain a sliding window such that
    //      (length of substring - number of times of the maximum occurring character in the substring) <= k
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        if (n == 0) return 0;
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
            char cur = s.charAt(end);
            Integer value = counter.get(cur) == null ? 0 : counter.get(cur);
            counter.put(cur, ++value);
            // update maxCount
            if (value > maxCount) {
                maxCount = value;
            }
            while (end - start - maxCount + 1 > k) {
                // shrink window
                char startChar = s.charAt(start);
                counter.put(startChar, counter.get(startChar) - 1);
                start++;
                // update maxCount
                Integer curMaxCount = 0;
                for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
                    curMaxCount = curMaxCount < entry.getValue() ? entry.getValue() : curMaxCount;
                }
                maxCount = curMaxCount;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
