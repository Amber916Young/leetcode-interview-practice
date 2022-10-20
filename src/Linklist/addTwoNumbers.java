package Linklist;

/**
 * @ClassName:addTwoNumbers
 * @Auther: yyj
 * @Description:
 * @Date: 20/10/2022 10:41
 * @Version: v1.0
 */

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class addTwoNumbers {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        int carry = 0 ;
        ListNode mergeList = new ListNode(0);
        ListNode head = mergeList;
        while (l1!=null || l2!=null){
            int l1_num = 0;
            int l2_num = 0;
            if(l1!=null){
                l1_num = l1.val;
                l1 = l1.next;
            }else l1_num=0;

            if(l2!=null){
                l2_num = l2.val;
                l2 = l2.next;
            }else l2_num=0;
            int temp = l1_num+l2_num+carry;
            if(temp>=10){
                carry=1;
                mergeList.next =  new ListNode(temp%10);
            }else {
                carry=0;
                mergeList.next= new ListNode(temp);
            }
            mergeList = mergeList.next;
        }
        if (carry==1) mergeList.next = new ListNode(1);
        return head.next;
    }
}
