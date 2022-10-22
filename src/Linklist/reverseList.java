package Linklist;

/**
 * @ClassName:reverseList
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/reverse-linked-list/
 * @Date: 22/10/2022 23:06
 * @Version: v1.0
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev =null;
        while (head!=null){
            ListNode next_node = head.next;
            head.next =prev;
            prev = head;
            head=next_node;
        }
        return prev;
    }
}
