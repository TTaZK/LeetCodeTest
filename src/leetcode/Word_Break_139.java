package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word_Break_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) return false;
        if (s.length() == 0) return false;

        // init
        Map<String, Integer> map = new HashMap<>();
        for (String ele : wordDict) {
            map.putIfAbsent(ele, 1);
        }
        // iterator
        int start, end;
        start = end = 0;
        // the end index is exclusive.
        while (end <= s.length()) {
            String cur = s.substring(start, end);
            // exist
            if (map.get(cur) != null) {
                start = end;
            } else {
                if (end == s.length()) return false;
            }
            end++;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> dic = new ArrayList<>();
        dic.add("aaa");
        dic.add("aaaa");
        dic.add("a");
        wordBreak("aaaaaaa", dic);
    }

}
