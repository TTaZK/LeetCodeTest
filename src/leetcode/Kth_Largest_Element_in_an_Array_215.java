package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// tag : divide and conquer
//  Note that it is the kth largest element in the sorted order, not the kth distinct element
public class Kth_Largest_Element_in_an_Array_215 {
    // 准备采用单调队列（单调递减）
    // 其中队列的长度固定
    // 运行速度很慢
    // 最常采用的方法是使用长度为 k 的优先队列，时间复杂度为 O(N * logK)
    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length) return 0;
        MonotonousQueue queue = new MonotonousQueue(k);
        for (int v : nums) {
            queue.add(v);
        }
        return queue.getResult();
    }

    static class MonotonousQueue {
        int length;
        List<Integer> queue = new ArrayList<>(length);

        // fixed queue length
        public MonotonousQueue(int n) {
            length = n;
        }

        // add an element
        public void add(int element) {
            if (queue.isEmpty()) {
                queue.add(element);
                return;
            }

            int index = 0;
            for (; index < queue.size(); index++) {
                if (element >= queue.get(index)) {
                    queue.add(index, element);
                    if (queue.size() > length) {
                        queue.remove(length);
                    }
                    return;
                }
            }
            if (index < length) {
                queue.add(index, element);
            }
        }

        // get result
        public int getResult() {
            return queue.get(length - 1);
        }
    }

    // 使用优先队列
    public int findKthLargest_1(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
