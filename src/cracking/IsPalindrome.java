package cracking;


import offer.LinkList.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 回文链表
 * @author wangxuanni
 * @since 2021-12-29 17:42
 **/

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stackVal = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        ListNode index = head;
        while (index != null) {
            stackVal.push(index.val);
            queue.offer(index.val);
            index = index.next;
        }
        while (!stackVal.isEmpty() && !queue.isEmpty()) {
            if (!stackVal.pop().equals(queue.poll())) {
                return false;
            }
        }
        return stackVal.isEmpty() && queue.isEmpty();
    }
}
