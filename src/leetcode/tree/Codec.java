package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-27 12:00
 **/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#_";
        String str = root.val+"_";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.offer(s);
        }
        return handler(queue);

    }

    private TreeNode handler(Queue<String> queue) {
        String poll = queue.poll();
        if ("#".equals(poll)) return null;
        TreeNode treeNode = new TreeNode(Integer.valueOf(poll));
        treeNode.left = handler(queue);
        treeNode.right = handler(queue);
        return treeNode;
    }

}
