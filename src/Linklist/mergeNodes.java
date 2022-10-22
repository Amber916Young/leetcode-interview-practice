package Linklist;

/**
 * @ClassName:mergeNodes
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/merge-nodes-in-between-zeros/
 * @Date: 22/10/2022 20:44
 * @Version: v1.0
 */
public class mergeNodes {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode curr = new ListNode();
        ListNode root = new ListNode();
        curr = root;
        while (head != null) {
            int data = head.val;
            sum += data;
            if (sum != 0 && data == 0) {
                curr.next = new ListNode(sum);
                curr = curr.next;
                sum = 0;
            }
            head = head.next;
        }
        return root.next;
    }
}
