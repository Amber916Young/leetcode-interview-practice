package Linklist;

/**
 * @ClassName:deleteMiddle
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/
 * @Date: 22/10/2022 23:52
 * @Version: v1.0
 */
public class deleteMiddle {

    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return new ListNode();
        ListNode slow  = head;
        ListNode fast  = head;
        ListNode cur  = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while (cur != null){
            ListNode nextNode  = cur.next;
            if(nextNode == slow){
                cur.next = slow.next;
            }
            cur = nextNode;
        }
        return head;
    }
}
