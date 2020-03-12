package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_Element_in_a_BST_230 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 因为是二叉查找树，所以对这个树进行中序遍历就能得到一个有序的数组
    // 相应的就比较容易找到第k个大小的值
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> travel = new ArrayList<>();
        inOrderTravel(root, travel);
        return travel.get(k);
    }

    public static void inOrderTravel(TreeNode root, List<Integer> travel) {
        if (root == null) return;
        inOrderTravel(root.left, travel);
        travel.add(root.val);
        inOrderTravel(root.right, travel);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        kthSmallest(root, 1);
    }

}
