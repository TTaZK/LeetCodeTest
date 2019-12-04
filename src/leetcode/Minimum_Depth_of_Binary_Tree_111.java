package leetcode;

// tag : tree
public class Minimum_Depth_of_Binary_Tree_111 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 到叶子节点的距离
    // 求树的最小深度：与树的最大深度优点不同
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        // 分别讨论当前节点是否是叶子节点及左右节点是否为空进行讨论
        if (root.left == null && root.right != null) return right;
        else if (root.left != null && root.right == null) return left;
        else if (root.left == null && root.right == null) return 1;
        else return Math.min(left, right);
    }

    // 求树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
