package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
    static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return ans;
        List<Integer> curPath = new ArrayList<>();
        curPath.add(root.val);
        traversal(root, sum, root.val, curPath);
        return ans;
    }

    // backing traversal
    // 该方式使用分支剪切，但是是针对节点中的每个元素都大于0才有效
    public static void traversal(TreeNode root, int target, int curSum, List<Integer> curPath) {
        if (root.left == null && root.right == null) {
            if (target == curSum) {
                // 如果不新建一个list，则其余分支遍历时会对该curPath进行操作
                List<Integer> curAns = new ArrayList<>(curPath);
                ans.add(curAns);
            }
        } else {
            if (curSum >= target) return;
            // traversal cur level
            // left
            if (root.left != null && curSum + root.left.val <= target) {
                // 符合限制
                curPath.add(root.left.val);
                traversal(root.left, target, curSum + root.left.val, curPath);
                curPath.remove(curPath.size() - 1);
            }

            // right
            if (root.right != null && curSum + root.right.val <= target) {
                curPath.add(root.right.val);
                traversal(root.right, target, curSum + root.right.val, curPath);
                curPath.remove(curPath.size() - 1);
            }
        }
    }

    // backing traversal
    // 对节点数据类型无要求
    public static void traversal_2(TreeNode root, int target, int curSum, List<Integer> curPath) {
        if (root.left == null && root.right == null) {
            if (target == curSum) {
                // 如果不新建一个list，则其余分支遍历时会对该curPath进行操作
                List<Integer> curAns = new ArrayList<>(curPath);
                ans.add(curAns);
            }
        } else {
            // traversal cur level
            // left
            if (root.left != null) {
                // 符合限制
                curPath.add(root.left.val);
                traversal_2(root.left, target, curSum + root.left.val, curPath);
                curPath.remove(curPath.size() - 1);
            }

            // right
            if (root.right != null) {
                curPath.add(root.right.val);
                traversal_2(root.right, target, curSum + root.right.val, curPath);
                curPath.remove(curPath.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-5);
        TreeNode left = new TreeNode(-3);
        TreeNode left_left = new TreeNode(-2);
        TreeNode right = new TreeNode(-2);
        root.left = left;
        left.left = left_left;
        root.right = right;
        pathSum(root, 10);
        for (List<Integer> meta : ans) {
            System.out.println(Arrays.toString(meta.toArray()));
        }
    }
}
