package leetcode;

import java.util.Map;

public class Grumpy_Bookstore_Owner_1052 {
    // tag : sliding window
    // 如果当前满意的人数为负，则不纳入计算（即只计算正值）
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int start, end;
        start = end = 0;
        // rebuild array
        int[] array = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {
            array[i] = grumpy[i] == 0 ? customers[i] : 0 - customers[i];
        }
        // init
        int maxSum = 0;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (end < X) {
                curSum += Math.abs(array[i]);
                end++;
            } else {
                // 负值不纳入计算
                curSum = array[i] >= 0 ? curSum + array[i] : curSum;
            }
        }
        maxSum = curSum;
        start++;
        // iterator
        while (end < array.length) {
            int s = array[start - 1] < 0 ? 0 - Math.abs(array[start - 1]) : 0;
            int e = array[end] < 0 ? Math.abs(array[end]) : 0;
            int sub = s + e;
            curSum += sub;
            maxSum = Math.max(maxSum, curSum);
            start++;
            end++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // [1,0,1,2,1,1,7,5]
        // [0,1,0,1,0,1,0,1]
        // 3
        // [1,0,1,2,1,1,7,5]
        // [0,1,0,1,0,1,0,1]
        // 3
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}

