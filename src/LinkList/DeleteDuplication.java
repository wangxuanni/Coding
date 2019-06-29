package LinkList;

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
                        n = n.next;//如果有多个重复 p不用动 n动到最后一个重复在删除
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
