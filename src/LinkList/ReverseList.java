package LinkList;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode pre=null;
        ListNode next=null;
        ListNode p=head;

        while(p!=null){
            next=p.next;
            if(next==null){
                head=p;
            }
            p.next=pre;
            pre=p;
            p=next;

        }
        return head;
    }
}
