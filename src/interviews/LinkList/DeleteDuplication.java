package interviews.LinkList;

    public class DeleteDuplication {

        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null || pHead.next == null) {
                return pHead;
            }
            ListNode newH = new ListNode(0);
            newH.next = pHead;
            ListNode p = newH;
            ListNode n = newH.next;

            while (n != null) {
                if (n.next != null && n.val == n.next.val) {
                    while (n.next != null && n.val == n.next.val) {
                        n = n.next;//����ж���ظ� p���ö� n�������һ���ظ���ɾ��
                    }
                    p.next = n.next;
                    n = n.next;
                } else {
                    p = p.next;
                    n = n.next;
                }
            }
            return newH.next;
        }

    }
