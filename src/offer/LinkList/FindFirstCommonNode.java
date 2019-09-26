package offer.LinkList;

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
