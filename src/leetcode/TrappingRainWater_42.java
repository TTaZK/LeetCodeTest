package leetcode;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int length = height.length;
        if (length <= 0) return 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int left = maxOfLeft(i, height);
            int right = maxOfRight(i, height);
            int shorter = left > right ? right : left;
            int cur = shorter > height[i] ? shorter - height[i] : 0;
            sum += cur;
        }
        return sum;
    }

    private int maxOfLeft(int index, int[] height) {
        if (index <= 0 || index >= height.length - 1) return 0;
        int max = height[0];
        for (int i = 0; i < index; i++) {
            max = max > height[i] ? max : height[i];
        }
        return max;
    }

    private int maxOfRight(int index, int[] height) {
        if (index <= 0 || index >= height.length - 1) return 0;
        int max = height[index + 1];
        for (int i = index + 1; i < height.length; i++) {
            max = max > height[i] ? max : height[i];
        }
        return max;
    }
}
