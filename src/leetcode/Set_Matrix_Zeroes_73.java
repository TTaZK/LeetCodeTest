package leetcode;

import java.util.Arrays;

// tag : array
public class Set_Matrix_Zeroes_73 {
    // space O(m+n)
    public static void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        // to store each state of row/column
        int[] row = new int[r];
        for (int i = 0; i < r; i++) {
            row[i] = 1;
        }
        int[] col = new int[c];
        for (int j = 0; j < c; j++) {
            col[j] = 1;
        }
        // iterate
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        // set specific rows to zeros
        for (int i = 0; i < r; i++) {
            if (row[i] == 0) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set specific columns to zeros
        for (int j = 0; j < c; j++) {
            if (col[j] == 0) {
                for (int i = 0; i < r; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
