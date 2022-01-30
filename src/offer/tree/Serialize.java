package offer.tree;

import leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wangxuanni
 * @since 2021-07-05 21:04
 **/

public class Serialize {
    public static void main(String[] args) {
        Serialize serialize = new Serialize();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(5);

        String serialize1 = serialize.serialize(root);
        serialize.deserialize(serialize1);
        System.out.println(serialize1);
    }

    //输入：root = [1,2,3,null,null,4,5]
    //输出：[1,2,3,null,null,4,5]
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }

        String valStr = String.valueOf(root.val) + ",";
        valStr += serialize(root.left);
        valStr += serialize(root.right);
        System.out.println(valStr);
        return valStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> strings = new LinkedList<String>(Arrays.asList(data.split(",")));
        return f(strings);
    }

    public static TreeNode f(LinkedList<String> strings) {
        String valStr = strings.get(0);
        if ("null".equals(valStr)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(valStr));
        strings.removeFirst();
        node.left = f(strings);
        node.right = f(strings);
        return node;
    }
}
