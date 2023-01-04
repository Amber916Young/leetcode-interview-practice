package Mock;

/**
 * @ClassName:deleteNode
 * @Auther: yyj
 * @Description:
 * @Date: 30/12/2022 15:52
 * @Version: v1.0
 */
public class deleteNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

}
