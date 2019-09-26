package offer.LinkList;


public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null||list2==null)
            return list1==null?list2:list1;
        ListNode pre=null;
        ListNode next=null;
        ListNode head=list1.val < list2.val?list1:list2;
        ListNode curM=list1.val < list2.val?list1:list2;
        ListNode curS=list1.val < list2.val?list2:list1;
        while(curM!=null&&curS!=null){
            if(curM.val<= curS.val){
                pre=curM;
                curM=curM.next;
            }else{
                next=curS.next;
                pre.next=curS;
                curS.next=curM;
                pre=pre.next;
                curS=next;
            }
        }
        pre.next=curM==null?curS:null;
        return head;
    }
}
