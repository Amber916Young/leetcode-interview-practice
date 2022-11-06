package Linklist;

/**
 * @ClassName:mergeTwoLists
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/merge-two-sorted-lists/submissions/
 * @Date: 05/11/2022 16:05
 * @Version: v1.0
 */
public class mergeTwoLists {


    // easy level
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        ListNode mergeList = new ListNode(-1);
        ListNode head = mergeList;
        while (l1!=null&&l2!=null){
            if(l1.val< l2.val){
                mergeList.next = l1;
                l1 = l1.next;
            }else {
                mergeList.next = l2;
                l2 = l2.next;
            }
            mergeList = mergeList.next;
        }
        if(l1!=null){
            mergeList.next = l1;
        }
        if(l2!=null){
            mergeList.next = l2;
        }
        return head.next;
    }
}
