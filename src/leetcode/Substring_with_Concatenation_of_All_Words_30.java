package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words_30 {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        findSubstring(s, words);

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (words.length <= 0) return null;
        int length = words[0].length() * words.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String[] slices = slice(s, i, i + length - 1, words[0].length());
            if (equal(slices, words)) {
                res.add(i);
            }
        }
        return res;
    }

    public static String[] slice(String s, int start, int end, int len) {
        if (start < 0 || end >= s.length() || start > end) return null;
        int l = (int) Math.ceil((end - start + 1) / len);
        String[] res = new String[l];
        int index = 0;
        for (int i = start; i < end; i += len) {
            String temp = s.substring(i, i + len);
            res[index] = temp;
            index++;
        }
        return res;
    }

    public static boolean equal(String[] src, String[] dest) {
        if (src == null || dest == null || src.length != dest.length) return false;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dest.length; i++) {
            if (map.get(dest[i]) == null) {
                map.put(dest[i], 1);
            } else {
                map.put(dest[i], map.get(dest[i]) + 1);
            }
        }

        for (int i = 0; i < src.length; i++) {
            Integer count = map.get(src[i]);
            if (count == null || count <= 0) return false;
            if (count == 1) {
                map.remove(src[i]);
            } else {
                map.put(src[i], count--);
            }
        }
        return true;
    }
}
