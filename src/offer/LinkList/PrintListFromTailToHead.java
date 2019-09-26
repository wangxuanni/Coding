package offer.LinkList;

import java.util.ArrayList;

/**
 * ��β��ͷ��ӡ����
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
