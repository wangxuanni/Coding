package leetcode.tree.dfs;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 路径总和 II
 * @author keyu
 * @since 2022-04-28 14:36
 **/

public class PathSum2 {
    //14min        preList.removeLast();
    int targetSum = 0;
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return new ArrayList<>();
        this.targetSum = targetSum;
        dfs(root, 0, new LinkedList<>());
        return list;
    }

    public void dfs(TreeNode root, int pre, LinkedList<Integer> preList) {
        if (root == null) return;
        //典型dfs
        pre += root.val;
        preList.addLast(root.val);
        if (root.left == null && root.right == null) {
            if (pre == targetSum) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(preList);
                list.add(temp);
            }
            preList.removeLast();
            return;
        }

        dfs(root.left, pre, preList);
        dfs(root.right, pre, preList);

        preList.removeLast();


    }
}
