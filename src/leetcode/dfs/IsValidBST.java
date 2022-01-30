package leetcode.dfs;

import leetcode.tree.TreeNode;

import java.util.ArrayList;

/**
 * @author zakree
 * @since 2022-01-14 10:40
 **/

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        f(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;

    }

    void f(TreeNode root, ArrayList list) {
        if (root == null)
            return;

        f(root.left, list);
        list.add(root.val);
        f(root.right, list);
    }

}
