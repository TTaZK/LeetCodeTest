package leetcode;

public class Minimum_Size_Subarray_Sum_209 {
    // 使用 left , right 两个指针
    // 如果两指针之间的子数组之和小于 s ，则 right 右移，扩大子数组
    // 否则，left 右移，缩小子数组
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length <= 0) return 0;
        int minLength = Integer.MAX_VALUE;
        int left, right;
        left = right = 0;
        int curSum = nums[0];

        while (right < nums.length && left <= right) {
            if (curSum < s) {
                right++;
                if (right == nums.length) break;
                curSum += nums[right];
            } else {
                minLength = Math.min(right - left + 1, minLength);
                curSum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int a = minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(a);
    }
}
