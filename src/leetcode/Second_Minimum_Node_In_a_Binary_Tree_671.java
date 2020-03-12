package leetcode;

public class Second_Minimum_Node_In_a_Binary_Tree_671 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 其实该二叉树类似于最小堆，根结点即为值最小的节点，只需要从根结点往下遍历并找到比根结点大的第一个值即可
    // 最后一个case不通过
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return -1;
        if (root.left != null && root.val < root.left.val) return root.left.val;
        if (root.right != null && root.val < root.right.val) return root.right.val;
        // 此时说明根结点的值与左右两个字节点的值相等
        // 继续向下遍历比较
        int left = findSecondMinimumValue(root.left);
        int right = findSecondMinimumValue(root.right);

        if ((left == right) && (right == root.val)) return -1;
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return Math.max(root.val, left);
        } else if (right != -1) {
            return Math.max(root.val, right);
        } else {
            return -1;
        }
    }

    public int findSecondMin(TreeNode root) {
        if (root.left == null) return -1;

        int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;

        return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
    }
}
