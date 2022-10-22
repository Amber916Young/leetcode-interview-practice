package Linklist;

/**
 * @ClassName:swapPairs
 * @Auther: yyj
 * @Description:
 * @Date: 22/10/2022 21:08
 * @Version: v1.0
 */
public class swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode n1 = head , n2 = head.next;
        n1.next = swapPairs(n2.next);
        n2.next = n1;
        return n2;
    }
}
