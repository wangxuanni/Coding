package leetcode.tree;

import java.util.HashMap;

/**
 * 从中序和后序遍历序列构造二叉树
 *
 * @author keyu
 * @since 2022-04-26 14:22
 **/
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        HashMap inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return doBuildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inorderMap);


    }

    public TreeNode doBuildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> inorderMap) {
        if (inStart > inEnd || inStart < 0 || inEnd > inorder.length - 1 || postStart < 0 || postEnd > postorder.length - 1) return null;
        //recording postorder know the root ,use root get left tree and right tree in inorder
        int root = postorder[postEnd];
        TreeNode node = new TreeNode(root);
        Integer rootIndex = inorderMap.get(root);
        // inorder and postorder of left tree into next recursion
        int leftLen = rootIndex - inStart;
        node.left = doBuildTree(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftLen - 1, inorderMap);
        // inorder and postorder of right tree into next recursion
        node.right = doBuildTree(inorder, postorder, rootIndex + 1, inEnd, postStart + leftLen, postEnd - 1, inorderMap);
        return node;

    }
}
