package Linklist;

/**
 * @ClassName:deleteNode
 * @Auther: yyj
 * @Description:
 * @Date: 22/10/2022 21:12
 * @Version: v1.0
 */
public class deleteNode {

    public void deleteNode(ListNode node) {
        ListNode nextnode = node.next;
        node.val = nextnode.val;
        node.next = nextnode.next;
        nextnode.next = null;
    }
}
