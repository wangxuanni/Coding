package LinkList;

/**
 * 寻找公共结点公共结点
 * 方法快慢指针
 * 如果有公共节点，1）若两个链表长度相等，那么遍历一遍后，在某个时刻，p1 == p2
 *  2)若两个链表长度不相等，那么短的那个链表的指针pn（也就是p1或p2） 必先为null，那么这时再另pn = 链表头节点。经过一段时间后，则一定会出现p1 == p2。 如果没有公共节点：这种情况可以看成是公共节点为null，顾不用再考虑。
 * 注意是平p1!=p2并且p1==null，才会被赋为头结点
 * 形成了两个环因为长度不一样终有一步会相遇，如果两个链表相等，第一次就会相遇
 */
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while(p1!=p2){
            if(p1!=null)p1=p1.next;
            if(p2!=null)p2=p2.next;
            if(p1!=p2){
                if(p1==null)p1=pHead1;
                if(p2==null)p2=pHead2;
            }
        }
        return p2;
    }
}
