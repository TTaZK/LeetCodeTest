package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

// tag : string
public class Multiply_Strings_43 {
    // `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
    // the length of result is `num1.length + number2.length - 1`
    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length() - 1];
        StringBuffer stb = new StringBuffer();
        if (num1.length() == 0 || num2.length() == 0) return "";
        for (int i = 0; i < num1.length(); i++) {
            int value_num1 = (int) num1.charAt(i);
            for (int j = 0; j < num2.length(); j++) {
                int value_num2 = (int) num2.charAt(j);
                // calculate
                int index_1 = i + j;
                int index_2 = i + j + 1;
                int cur_value = value_num1 * value_num2;
                calculate(result, index_1, index_2, cur_value);
            }
        }
        for (int i = 0; i < result.length; i++) {
            stb.append(result[i]);
        }
        return null;
    }

    public static void calculate(int[] result, int index_1, int index_2, int cur_value) {
        int index_1_val = cur_value / 10;
        int index_2_val = cur_value % 10;

        int p = (result[index_2] + index_2_val) / 10;
        int q = (result[index_2] + index_2_val) % 10;
        result[index_2] = q;
        if (p + index_1_val + result[index_1] < 10) {
            result[index_1] = p + index_1_val + result[index_1];
        } else {
            calculate(result, index_1 - 1, index_2 - 1, p + index_1_val);
        }
    }

    public static void main(String[] args) {
//        int a = 58;
//        int[] res = new int[]{5, 7, 3};
//        calculate(res, 1, 2, a);
//        System.out.println(Arrays.toString(res));
        System.out.println(multiply("12", "12"));
    }
}
