package leetcode;

public class Max_Consecutive_Ones_III_1004 {
    public static int longestOnes(int[] A, int K) {
        int n = A.length;
        if (n <= K) return n;
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

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 0, 0, 1, 0, 1};
        System.out.println(longestOnes(arr, 2));
    }
}
