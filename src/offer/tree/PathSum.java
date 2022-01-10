package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * todo 有待改进
 * @author keyu
 * @since 2022-01-04 16:04
 **/

public class PathSum {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-2);
        TreeNode right = new TreeNode(-3);
        root.right = right;
//        right.left = new TreeNode(4);
//        right.right = new TreeNode(5);
        List<List<Integer>> lists = pathSum(root, -5);
        System.out.println(lists);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> currentList = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        f(root, targetSum,  currentList, result);
        return result;
    }

    public static void f(TreeNode root, int targetSum, LinkedList<Integer> currentList, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        targetSum-=root.val;
        currentList.add(root.val);

        if (root.left == null && root.right == null&&targetSum == 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.addAll(currentList);
                result.add(list);
        }

        f(root.left, targetSum, currentList, result);
        f(root.right, targetSum, currentList, result);
        currentList.removeLast();
    }
}
