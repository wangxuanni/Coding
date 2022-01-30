package offer.tree;

import java.util.ArrayList;

/**
 * @author zakree
 * @since 2022-01-07 18:31
 **/

public class KthLargest {
    public int kthLargest(TreeNode root, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        f(root, k, list);
        return list.get(list.size() - 1 - k>0?list.size() - 1 - k:list.size() - 1 );

    }

    public void f(TreeNode root, int k, ArrayList<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        f(root.left, k,list);
        f(root.right, k,list);
    }

}
