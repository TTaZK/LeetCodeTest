package leetcode;

public class Median_of_Two_Sorted_Arrays_4 {

    // 类比于归并排序
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l_1 = nums1.length;
        int l_2 = nums2.length;
        int l = l_1 + l_2;
        int[] merge = new int[l];

        int index, index_1, index_2;
        index = index_1 = index_2 = 0;

        while (index < l) {
            int value_1, value_2;
            value_1 = value_2 = Integer.MAX_VALUE;
            if (index_1 < l_1) {
                value_1 = nums1[index_1];
            }
            if (index_2 < l_2) {
                value_2 = nums2[index_2];
            }
            // input into merged array
            int value = Math.min(value_1, value_2);
            merge[index++] = value;

            if (value == value_1) {
                index_1++;
            } else {
                index_2++;
            }
        }

        if (l % 2 == 0) {
            return ((double) merge[l / 2] + (double) merge[l / 2 - 1]) / 2;
        } else {
            return merge[l / 2];
        }
    }

    public static void main(String[] args) {
        double a = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(a);
    }
}
