package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// tag : tree, traversal
public class Binary_Tree_Level_Order_Traversal_II_107 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 可以参考从上到下的层次遍历，最后将遍历结果倒序排列输出
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> parent = new ArrayDeque<>();
        Queue<TreeNode> child = new ArrayDeque<>();
        parent.add(root);
        // 至少有一个不为空
        while (!parent.isEmpty() || !child.isEmpty()) {
            List<Integer> p = new ArrayList<>();
            while (!parent.isEmpty()) {
                TreeNode header = parent.poll();
                if (header.left != null) child.offer(header.left);
                if (header.right != null) child.offer(header.right);
                p.add(header.val);
            }
            // 将节点从 child 转移到 parent
            while (!child.isEmpty()) {
                TreeNode c = child.poll();
                parent.offer(c);
            }
            res.add(new ArrayList<>(p));
            p.clear();
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ret.add(res.get(i));
        }
        return ret;
    }
}
