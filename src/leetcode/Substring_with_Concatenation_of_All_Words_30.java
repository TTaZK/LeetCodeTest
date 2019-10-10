package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        return null;
    }

    public String[] slice(String s, int start, int end, int len) {
        if (start < 0 || end >= s.length()) return null;
        return null;
    }

    public boolean equal(String[] src, String[] dest) {
        if (src.length != dest.length) return false;
        Map<String, Integer> map = new HashMap<>(dest.length);
        for (int i = 0; i < dest.length; i++) {
            map.put(dest[i], map.get(dest[i]) + 1);
        }
        for (int i = 0; i < src.length; i++) {
            Integer count = map.get(src[i]);
            if (count <= 0) return false;
            if (count == 1) {
                map.remove(src[i]);
            } else {
                map.put(src[i], count--);
            }
        }
        return true;
    }
}
