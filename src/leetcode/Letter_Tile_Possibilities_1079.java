package leetcode;

import java.util.HashSet;
import java.util.Set;

// tag : backtracking
// 子集树 + 排列树
public class Letter_Tile_Possibilities_1079 {
    static Set<String> res = new HashSet<>();

    public static int numTilePossibilities(String tiles) {
        if (tiles.length() <= 0) return 0;
        backtracking(tiles, 0, "", res);
        return res.size() - 1;
    }

    public static void backtracking(String titles, int level, String cur, Set<String> res) {
        if (level >= titles.length()) {
            if (cur.length() >= 0) {
                permutation(cur.toCharArray(), 0, res);
            }
        } else {
            // 0
            backtracking(titles, level + 1, cur, res);
            // 1
            cur = cur + titles.charAt(level);
            backtracking(titles, level + 1, cur, res);
        }
    }

    public static void permutation(char[] input, int level, Set<String> res) {
        if (level >= input.length) {
            res.add(new String(input));
        } else {
            for (int i = level; i < input.length; i++) {
                swap(input, level, i);
                permutation(input, level + 1, res);
                // recover
                swap(input, level, i);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public int numTilePossibilities(String tiles) {
//        int[] count = new int[26];
//        for (char c : tiles.toCharArray()) count[c - 'A']++;
//        return dfs(count);
//    }
//
//    int dfs(int[] arr) {
//        int sum = 0;
//        for (int i = 0; i < 26; i++) {
//            if (arr[i] == 0) continue;
//            sum++;
//            arr[i]--;
//            sum += dfs(arr);
//            arr[i]++;
//        }
//        return sum;
//    }
//    Thoughts
//
//    input: AAB
//    count: A -> 2, B -> 1
//
//    For sequence of length 1:
//
//    We can pick either A, or B.
//    So we have "A", "B".
//    For sequence of length 2:
//
//    We build it based on "sequence of length 1"
//    For "A":
//    count: A -> 1, B -> 1
//    We can still pick either A, or B
//    So we have "AA", "AB"
//    For "B":
//    count: A -> 2, B -> 0
//    We can only pick A
//    So we have "BA"
//    For sequence of length 3: blablabla
//
//            Implementation
//
//    We don't need to keep track of the sequence. We only need count
//    If we implement the above idea by each level (Count all sequence of length 1, then count all sequence of length 2, etc), we have to remember previous sequence.
//    So we use recursion instead. Just remember to add the count back (arr[i]++).

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }
}
