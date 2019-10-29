package leetcode;

import java.util.ArrayList;
import java.util.List;

public class First_Missing_Positive_41_2 {
    public static void main(String[] args) {
        firstMissingPositive(new int[]{7, 8, 9, 11, 12});
    }

    public static int firstMissingPositive(int[] nums) {
        MonotonousQueue queue = new MonotonousQueue();
        for (int value : nums) {
            if (value <= 0) continue;
            queue.push(value);
        }
        if (queue.size() == 0 || queue.get(queue.size() - 1) > 1) return 1;
        int v = queue.get(0);
        for (int i = queue.size() - 2; i >= 0; i--) {
            if (queue.get(i) >= queue.get(i + 1) + 2) {
                v = queue.get(i + 1);
                break;
            }
        }
        return v == 1 ? 2 : v + 1;

    }

    // 参考单调队列的思想
    // 维护一个正数的单调递减队列
    // 速度太慢
    static class MonotonousQueue {
        List<Integer> list = new ArrayList<>();

        public void push(int value) {
            if (list.isEmpty() || list.get(list.size() - 1) >= value) {
                list.add(value);
                return;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) <= value) {
                    list.add(i, value);
                    return;
                }
            }
        }

        public int size() {
            return list.size();
        }

        public int get(int index) {
            return list.get(index);
        }
    }

    // 参考讨论中的解析
    // Put each number in its right place.
    // For example:
    // When we find 5, then swap it with A[4].
    // At last, the first place where its number is not right, return the place + 1.
    // 缺少的最小正元素的取值范围为[ 1 ,n ]。如果数组中的某个元素大小大于数组的长度，则将该元素置为 0
    public static int firstMissingPositive_1(int[] nums) {
        int n = nums.length;
        // Put each number in its right place.
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 0;
                continue;
            }
            swap(nums, i, nums[i] - 1);
        }
        // unfinished
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > 0) {
                if (nums[i + 1] - nums[i] >= 2) {
                    return nums[i] + 1;
                }
                continue;
            }
        }
        return 0;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
