package leetcode;

// tag : binary search
public class Maximum_Length_of_Repeated_Subarray_718 {

    // 可以使用暴力法求解，时间复杂度为O(n^2)
    // 大量数据时造成超时
    // 最后几个 case 未通过
    public static int findLength_1(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;
        int max_length = 0;
        for (int i = 0; i < A.length; i++) {
            int index = i;
            int curLength = 0;
            int start = B.length;
            for (int j = 0; j < B.length; j++) {
                if (index < A.length && A[index] == B[j]) {
                    // A,B 首个相同字符的位置
                    if (A[i] == B[j]) start = Math.min(start, j);
                    curLength++;
                    index++;
                } else if (curLength > 0) {
                    // reset
                    curLength = 0;
                    index = i;
                    j = start;
                    start = B.length;
                }
                max_length = Math.max(max_length, curLength);
            }
        }
        return max_length;
    }

    // 类比最长公共子串（不是子序列）
    // 状态转移方程为 C[i][j] = 0 (A[i] != B[j]) ; C[i][j] = C[i-1][j-1]+1 (A[i] == B[j])
    public static int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0) return 0;
        int[][] C = new int[m + 1][n + 1];
        // record max length of subString
        int len = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    len = Math.max(len, C[i][j]);
                } else
                    C[i][j] = 0;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 1, 1
        }, new int[]{1, 1, 2}));
    }
}
