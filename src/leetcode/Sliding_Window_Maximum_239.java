package leetcode;

import java.util.*;

public class Sliding_Window_Maximum_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        List<Integer> window = new ArrayList<>();
        if (nums.length <= 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int end = 0;
        int index = 0;
        // init
        for (; end < k; end++) {
            monotonicQueue.push(nums[end]);
            window.add(nums[end]);

        }
        res[index] = monotonicQueue.top();
        index++;
        // iterator
        while (end < nums.length) {
            int top = window.remove(0);
            window.add(nums[end]);

            monotonicQueue.pop(top);
            monotonicQueue.push(nums[end]);
            res[index] = monotonicQueue.top();

            index++;
            end++;
        }
        return res;
    }

    // Monotonic Queue Struct
    // Monotonically decreasing queue
    // The element in the queue`s head is the Max element
    static class MonotonicQueue {
        List<Integer> monotonic_queue = new ArrayList<>();

        public void push(int element) {
            //queue.push(element);
            //
            while (!monotonic_queue.isEmpty()) {
                int index = monotonic_queue.size() - 1;
                if (monotonic_queue.get(index) < element) {
                    monotonic_queue.remove(index);
                } else {
                    break;
                }
            }
            monotonic_queue.add(element);
        }

        public void pop(int top) {
            //int h = queue.pop();
            if (top == monotonic_queue.get(0)) {
                monotonic_queue.remove(0);
            }
        }

        public int top() {
            return monotonic_queue.get(0);
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}
