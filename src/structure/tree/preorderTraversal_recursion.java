package structure.tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归写法，很简单
 * @author wangxuanni
 * @since 2021-06-14 19:47
 **/

public class preorderTraversal_recursion {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList list = new ArrayList<Integer>();
        return f(root, list);

    }

    public static List<Integer> f(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        list.add(root.val);
        f(root.left, list);
        f(root.right, list);
        return list;
    }

}
