package exam.nowcoder;

public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p = pHead, q = pHead;
        int count = 0, flag = 0;
        while (q != null){
            p = p.next;
            if (p == null) return null;
            q = q.next.next;
            if (p == q){
                p = pHead;
                while (p != q){
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }

        return null;
    }
}
