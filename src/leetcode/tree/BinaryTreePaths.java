package leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2019-09-24 10:25
 **/

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left= new TreeNode(2);
        treeNode.right =new TreeNode(3);
        List<String> strings = binaryTreePaths(treeNode);
        System.out.println(strings.toString());

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) return list;

        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        List<String> leftList = binaryTreePaths(root.left);
        for (String s : leftList) {
            list.add(String.valueOf(root.val) + "->" + s);
        }
        List<String> rightList = binaryTreePaths(root.right);
        for (String s1 : rightList) {
            list.add(String.valueOf(root.val) + "->" + s1);
        }
        return list;

    }


}