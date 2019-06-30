package LinkList;

import java.util.ArrayList;

/**
 * 从尾到头打印链表
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list=printListFromTailToHead(listNode.next);
        list.add(listNode.val);
        return list;
    }
}
