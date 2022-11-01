package Tree;

/**
 * @ClassName:isSubPath
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/linked-list-in-binary-tree/
 * @Date: 01/11/2022 20:22
 * @Version: v1.0
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class isSubPath {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null ) return false;
        ListNode cur = head;
        boolean flag = false;
        if(root.val == cur.val){
            flag =  isSubPath_DFS(cur,root);
            System.out.println(flag);
        }
        return flag || isSubPath(cur,root.left) ||  isSubPath(cur,root.right);
    }

    private boolean isSubPath_DFS(ListNode head, TreeNode root) {
        if( head == null) return true;
        if(root == null) return false;
        System.out.println(head.val);
        head = head.next;
        return head.val == root.val &&(isSubPath_DFS(head,root.right) || isSubPath_DFS(head,root.left));
    }
}
