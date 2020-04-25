package leetcode.link;

import java.util.ArrayList;

/**
 * @description:
 * @author: wangxuanni
 * @create: 2020-04-25 12:28
 **/

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size()-1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end)))return false;
            start++;
            end--;
        }
        return true;
    }
}
