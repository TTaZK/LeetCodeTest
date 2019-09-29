package leetcode;

public class First_Missing_Positive_41 {

    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(array));
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums.length <= 0) return 0;
        if (nums.length == 1) {
            if (nums[0] > 1)
                return nums[0] - 1;
            else return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            // 如果前一个元素小于当前元素，或者前一个元素为非正值，则进行交换
            int index = i;
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] > nums[index]) {
                    swap(nums, index, j);
                    index = j;
                    j--;
                } else if (nums[j] <= 0) {
                    j--;
                } else {
                    break;
                }
            }
        }
        if (nums[0] > 1) return 1;
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 < nums[i + 1]) {
                min = nums[i] + 1;
                break;
            } else if (nums[i + 1] <= 0) {
                min = nums[i] + 1;
                break;
            }
        }
        return min;
    }
}


