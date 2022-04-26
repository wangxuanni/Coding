package leetcode.tree;

/**
 * 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author keyu
 * @since 2022-04-26 16:48
 **/

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);

    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;

        //find the array's median
        int median = (start + end) / 2;
        TreeNode root = new TreeNode(nums[median]);

        root.left = buildTree(nums, start, median - 1);
        root.right = buildTree(nums, median + 1, end);
        return root;
    }
    //[-10,-3,0,5,9]
}
