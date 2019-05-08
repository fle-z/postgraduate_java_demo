package exam.nowcoder;

public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        p.next = null;
        while (q != null) {
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }

        return p;
    }
}
