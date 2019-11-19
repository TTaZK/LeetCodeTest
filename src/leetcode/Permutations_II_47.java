package leetcode;

import java.util.*;

// tag : backtracking
public class Permutations_II_47 {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length <= 0) return ans;
        backTracking(nums, 0);
        for (List<Integer> el : set) {
            ans.add(el);
        }
        return ans;
    }

    public void backTracking(int[] nums, int level) {
        if (level >= nums.length) {
            set.add(arrToList(nums));
        } else {
            for (int i = level; i < nums.length; i++) {
                swap(nums, level, i);
                backTracking(nums, level + 1);
                // recover
                swap(nums, level, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> arrToList(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int v : nums) {
            ans.add(v);
        }
        return ans;
    }


    public static void main(String[] args) {
        Permutations_II_47 p = new Permutations_II_47();
        List<List<Integer>> ans = p.permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> el : ans) {
            System.out.println(Arrays.toString(el.toArray()));
        }
    }
}
