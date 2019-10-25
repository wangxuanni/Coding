package leetcode.tree;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-10-22 15:18
 **/

public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    public static int findPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum){
            res += findPath(root.left, sum - root.val);
            res += findPath(root.right, sum - root.val);
            return res+=1;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}