package LinkList;

/**
 * 合并两个有序链表
 *  选一主一从
 */
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
                next=curS.next;//记录从结点下个要遍历
                //插入从结点
                pre.next=curS;
                curS.next=curM;
                //相当于下一个
                pre=pre.next;//为下一个遍历做准备
                curS=next;//恢复
            }
        }
        pre.next=curM==null?curS:null;
        return head;
    }
}
