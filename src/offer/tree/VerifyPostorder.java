package offer.tree;

/**
 * 二叉搜索树的后序遍历序列
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @author keyu
 * @since 2022-03-16 11:51
 **/

public class VerifyPostorder {
    int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return f(0, postorder.length - 1);
    }

    public boolean f(int start, int end) {
        if (start >= end) {
            return true;
        }
        int count = end - 1;
        int root = postorder[end];
        while (count >= start && root < postorder[count]) {
            count--;
        }
        //检查左子树的值都比root小
        for (int i = start; i <= count; i++) {
            if (postorder[i] > root) return false;
        }
        //检查右子树的值都比root大
        for (int i = count + 1; i <= end - 1; i++) {
            if (postorder[i] < root) return false;

        }
        return f(start, count) && f(count + 1, end - 1);

    }


}
