package Linklist;

import java.util.Stack;

/**
 * @ClassName:splitListToParts
 * @Auther: yyj
 * @Description:
 * @Date: 26/10/2022 21:28
 * @Version: v1.0
 */
public class splitListToParts {
    public static void main(String[] args) {
        splitListToParts test = new  splitListToParts();

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        node1.next.next.next.next .next.next= new ListNode(7);
        node1.next.next.next.next.next.next.next = new ListNode(8);
        node1.next.next.next.next.next.next.next.next = new ListNode(9);
        node1.next.next.next.next .next.next.next.next.next= new ListNode(10);
        test.splitListToParts(node1,3);
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }
        int width = N / k, rem = N % k;
        ListNode[] ans = new ListNode[k];
        cur = head;

        for (int i = 0; i < k; ++i) {
            ListNode root = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = root;
        }
        return ans;
    }
}
