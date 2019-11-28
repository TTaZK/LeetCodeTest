package leetcode;

// tag: string
public class Reverse_Words_in_a_String_151 {
    // 如果只是求出结果，不考虑时间复杂度与空间复杂度，相对来说比较容易
    // 但是如果要求空间复杂度为O(1)
    // 该解法不考虑空间复杂度
    public static String reverseWords(String s) {
        if (s.length() <= 0) return "";
        String[] strings = s.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i]);
            if (strings[i].equals("")) continue;
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String i = "  hello world!  ";
        reverseWords(i);
    }
}
