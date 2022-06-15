package offer.tree;

import java.util.HashMap;

/**
 * 从前序和中序构建二叉树
 *
 * @author wangxuanni
 * @since 2021-06-06 18:02
 **/

public class buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return f(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]
    public static TreeNode f(int[] pre, int[] in, int preS, int preE, int inS, int inE) {
        if (preS < 0 || preE >= pre.length || inS < 0 || inE >= in.length || preS > preE || inS > inE) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[preS]);

        for (int i = inS; i <= inE; i++) {
            if (pre[preS] == in[i]) {
                treeNode.left = f(pre, in, preS + 1, preE + i - inS, inS, i - 1);
                treeNode.right = f(pre, in, preS + 1 + i, preE, i + 1, inE);
            }
        }
        return treeNode;
    }

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    TreeNode recur(int root, int left, int right) {
        if (left > right)
            return null; // 递归终止
        System.out.println("建立根节点：" + preorder[root]);
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);//获取根节点在中序遍历的坐标，这样能知道左右子树的长度
        System.out.println("root:" + root + "left:" + left + "right:" + right);
        System.out.println("开启左子树递归" + "root:" + "left:" + "right:");
        node.left = recur(root + 1, left, i - 1);//  node
        int i1 = root + i - left + 1;
        System.out.println("开启右子树递归" + i1 + "left:" + i + 1 + "right:" + right);
        node.right = recur(root + i - left + 1, i + 1, right);// 开启右子树递归
        return node; // 回溯返回根节点

    }
}