package leetcode;

public class Max_Consecutive_Ones_III_1004 {
    // tag: sliding window
    public static int longestOnes(int[] A, int K) {
        int n = A.length;
        if (n <= K) return n;
        // used to mark the number of 0
        int counter = K;
        int start, end, maxLength;
        start = end = maxLength = 0;
        while (end < n) {
            // expand the window : end pointer move to right
            if (counter >= 0) {
                // 如果此时 counter == 0，但是 A[end] == 1，则继续扩大窗口
                if (A[end] == 0) {
                    counter--;
                }
                // 如果 counter < 0，则肯定存在 A[end] == 0
                if (counter < 0) continue;
                int curLength = end - start + 1;
                maxLength = Math.max(maxLength, curLength);
                end++;
            } else {
                // shrink the window : start pointer move to right
                while (counter < 0) {
                    if (A[start] == 0) {
                        counter++;
                        // 因为进入该代码块时，肯定存在 A[end] == 0
                        // 需要同时修改 end 指针指向的位置，不然外层循环无法进行下去
                        end++;
                    }
                    start++;
                }
            }
        }
        return maxLength;
    }

    // 讨论中的参考答案
    public int longestOnes_1(int[] A, int K) {
        int zeroCount = 0, start = 0, res = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) zeroCount++;
            while (zeroCount > K) {
                if (A[start] == 0) zeroCount--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 0, 0, 1, 0, 1};
        System.out.println(longestOnes(arr, 2));
    }
}
