package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// tag : tree & traversal
public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // "Z"字形遍历：先从左到右，再从右到左
    // 参考水平遍历（NO.43），在每次取子节点的时候
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> parent = new ArrayDeque<>();
        Queue<TreeNode> child = new ArrayDeque<>();
        // 偶数：从左到右；奇数：从右到左
        int count = 0;
        parent.offer(root);
        while (!parent.isEmpty() || !child.isEmpty()) {
            while (!parent.isEmpty()) {
                if (count % 2 == 0) {

                } else {

                }
            }
            while (!child.isEmpty()) {
                parent.offer(child.poll());
            }
        }
        return null;
    }
}
