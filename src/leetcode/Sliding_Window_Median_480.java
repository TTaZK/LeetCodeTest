package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sliding_Window_Median_480 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 4, 2, 3}, 4)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return null;
        // init
        MonotonicQueue queue = new MonotonicQueue();
        double[] res = new double[n - k + 1];
        int index = 0;
        int start = 0;
        int end = 0;
        for (; end < k; end++) {
            queue.push(nums[end]);
        }
        res[index] = queue.median();
        index++;
        while (end < n) {
            queue.push(nums[end]);
            queue.pop(nums[start]);

            res[index] = queue.median();
            index++;
            start++;
            end++;
        }
        return res;
    }

    // 借鉴单调队列的思想，维护一个辅助队列，队列中的元素单调递增/递减
    // 相对于单调队列（主要用于求当前队列中的最大值/最小值），如果新增的元素比队列中的所有元素都大/小，
    // 队列中的元素不删除（为了求中位数）
    // 辅助队列的长度保持不变
    // Monotonic Queue Struct
    // 在进行push(),pop()的时间复杂度是O(K)，当case较大时，会导致time limit exceed
    static class MonotonicQueue {
        List<Integer> temp = new LinkedList<>();

        // add a new element into queue tail
        public void push(int element) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) <= element) {
                temp.add(element);
                return;
            }

            if (temp.get(0) >= element) {
                temp.add(0, element);
                return;
            }
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) >= element) {
                    temp.add(i, element);
                    return;
                }
            }
        }

        // if current element exists queue ,then pop it and return true
        // else do nothing and return false
        public boolean pop(int element) {
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) == element) {
                    temp.remove(i);
                    return true;
                }
            }
            return false;
        }

        // return current median
        public double median() {
            int middle = temp.size() / 2;
            if (temp.size() % 2 == 0) {
                return (temp.get(middle).doubleValue() + temp.get(middle - 1).doubleValue()) / 2;
            } else {
                return temp.get(middle);
            }
        }
    }
}
