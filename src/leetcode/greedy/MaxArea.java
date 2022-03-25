package leetcode.greedy;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author keyu
 * @since 2022-03-25 10:40
 **/

public class MaxArea {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        int min = 0;
        while (start < end) {
            min = Math.min(height[start], height[end]);
            max = Math.max((end - start) * min, max);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }

        }
        return max;
    }
}
