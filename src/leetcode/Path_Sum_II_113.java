package leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Path_Sum_II_113 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        List<Integer> curPath = new ArrayList<>();
        traversal(root, sum, 0, curPath);
        return ans;
    }

    // backing traversal
    public void traversal(TreeNode root, int target, int curSum, List<Integer> curPath) {
        if (root == null) {
            if (target == curSum) {
                // 如果不新建一个list，则其余分支遍历时会对该curPath进行操作
                List<Integer> curAns = new ArrayList<>(curPath);
                ans.add(curAns);
            }
        } else {
            if (curSum >= target) return;
            // traversal cur level
            // left
            if (curSum + root.left.val < target) {
                // 符合限制
                curPath.add(root.left.val);
                traversal(root.left, target, curSum + root.left.val, curPath);
                curPath.remove(curPath.size() - 1);
            }

            // right
            if (curSum + root.right.val < target) {
                curPath.add(root.right.val);
                traversal(root.right, target, curSum + root.right.val, curPath);
                curPath.remove(curPath.size() - 1);
            }
        }
    }
}
