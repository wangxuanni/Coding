package leetcode.tree;

import interviews.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-24 10:25
 **/

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, 0, 0);
        return new ArrayList<>();
    }

    public void binaryTreePaths(TreeNode root, int path, int sum) {
        if (root == null) {
            System.out.println(path);
        } else {
            path += root.val;
            sum = sum < path ? path : sum;
            binaryTreePaths(root.left, path, sum);
            binaryTreePaths(root.right, path, sum);
        }
    }


}