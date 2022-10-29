package Linklist;

import java.util.Stack;

/**
 * @ClassName:pairSum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * @Date: 26/10/2022 21:15
 * @Version: v1.0
 */
public class pairSum {
    public int pairSum(ListNode head) {
        Stack<ListNode> st=new Stack();
        ListNode temp = head;
        while(temp!=null){
            st.push(temp);
            temp=temp.next;
        }
        temp=head;
        int max=Integer.MIN_VALUE;
        int size=st.size();
        while(st.size()>size/2){
            int last=st.pop().val;
            int first=temp.val;
            max=Math.max(max,(first+last));
            temp = temp.next;
        }
        return max;
    }
}
