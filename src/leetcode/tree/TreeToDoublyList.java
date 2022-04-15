package leetcode.tree;

/**
 * TreeToDoublyList
 * @author keyu
 * @since 2022-03-24 18:15
 **/

public class TreeToDoublyList {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeToDoublyList(treeNode);
    }

    public static TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode pre = null;
        TreeNode head = null;
        TreeNode cur = root;
        dfs(cur, pre, head);
        head.left = pre;
        pre.right = head;
        return head;


    }

    public static void dfs(TreeNode cur, TreeNode pre, TreeNode head) {
        if (cur == null) return;
        dfs(cur.left, pre, head);
        if (pre != null) {
            pre.right = cur;
            cur.left = pre;
        } else {
            head = cur;
        }
        pre = cur;
        dfs(cur.right, pre, head);
        return;

    }

}
