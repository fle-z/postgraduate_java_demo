package exam.nowcoder;

public class MergeList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val){
                p = list2;
                list2 = list2.next;
            } else {
                p = list1;
                list1 = list1.next;
            }
            p = p.next;
        }

        if(list1 != null){
            list2 = list1;
        }

        p.next = list2;

        return p;
    }
}
