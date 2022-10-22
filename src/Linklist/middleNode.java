package Linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:middleNode
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/middle-of-the-linked-list/
 * @Date: 22/10/2022 22:50
 * @Version: v1.0
 */
public class middleNode {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // not prefect method
    public ListNode middleNode2(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }
}
