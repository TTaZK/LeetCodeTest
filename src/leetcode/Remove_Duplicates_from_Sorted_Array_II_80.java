package leetcode;

// tag : two pointers
public class Remove_Duplicates_from_Sorted_Array_II_80 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int start, end;
        start = end = 0;
        int le = n;
        while (end < n) {
            if (nums[end] == nums[start]) {
                end++;
                continue;
            }
            // 计算 end 与 start 之间的长度
            // ps : 此时 nums[end] != nums[start]
            // 长度计算出来了，但是需要对数组进行原地移动
            int sub = end - start;
            if (sub > 2) {
                le -= (sub - 2);
            }
            start = end;
        }
        return le;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
