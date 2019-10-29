package leetcode;

import java.util.Arrays;

public class Move_Zeroes_283 {
    // 使用 left ,right 两个指针
    // left 指向 0 ，right 指向非 0
    // 移动两个指针直到满足条件，交换两指针的值
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n <= 0) return;
        int left, right;
        left = right = 0;
        while (right < n) {
            // to find specific
            while (nums[left] != 0) {
                left++;
                if (left >= n) {
                    return;
                }
            }
            while (nums[right] == 0) {
                right++;
                if (right >= n) {
                    return;
                }
            }
            if (left < right) {
                // swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                // move the pointers
                left++;
                right++;
            } else {
                // 当left 在 right 后面时，保持 left 不动，继续移动 right
                right++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 1};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}
