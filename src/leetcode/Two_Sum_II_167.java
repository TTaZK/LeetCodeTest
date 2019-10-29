package leetcode;

// tag : two pointers
public class Two_Sum_II_167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                int[] re = new int[2];
                re[0] = start + 1;
                re[1] = end + 1;
                return re;
            }
        }
        return null;
    }
}
