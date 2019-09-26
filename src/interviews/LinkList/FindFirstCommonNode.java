package interviews.LinkList;

/**
 * Ѱ�ҹ�����㹫�����
 * ��������ָ��
 * ����й����ڵ㣬1����������������ȣ���ô����һ�����ĳ��ʱ�̣�p1 == p2
 *  2)�����������Ȳ���ȣ���ô�̵��Ǹ������ָ��pn��Ҳ����p1��p2�� ����Ϊnull����ô��ʱ����pn = ����ͷ�ڵ㡣����һ��ʱ�����һ�������p1 == p2�� ���û�й����ڵ㣺����������Կ����ǹ����ڵ�Ϊnull���˲����ٿ��ǡ�
 * ע����ƽp1!=p2����p1==null���Żᱻ��Ϊͷ���
 * �γ�����������Ϊ���Ȳ�һ������һ�����������������������ȣ���һ�ξͻ�����
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
