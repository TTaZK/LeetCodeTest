package leetcode;

import java.util.HashSet;
import java.util.Set;

public class K_diff_Pairs_in_an_Array_532 {
    // 使用一个辅助数组，长度等于 nums 中的元素最大值
    // 将 nums 中的元素放在辅助数组中的对应位置，如：i = nums[1], 那么nums[1]就被放在辅助数组的第 i 个位置上
    // 该方法会存在 nums 的长度较短，但是存在其中一个很大的数字，会导致不必要的空间浪费
    // 时间复杂度为 O(n)
    public int findPairs_1(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int value : nums) {
            max = Math.max(max, value);
        }
        if (max == Integer.MIN_VALUE) return 0;
        // create a temp array
        int[] temp = new int[max];
        // input element into temp array
        for (int value : nums) {
            // if (temp[value-1])
        }
        return 0;
    }

    // 可以先对数组去重，之后遍历数组，对于每个元素 i，其 +/- k 的值是确定的
    // 两个指针，双层遍历
    public static int findPairs(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int count = findPairs(new int[]{1, 3, 1, 4, 1, 5}, 2);
        System.out.println(count);
    }
}
