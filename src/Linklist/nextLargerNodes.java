package Linklist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName:nextLargerNodes
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/next-greater-node-in-linked-list/submissions/
 * @Date: 23/10/2022 00:14
 * @Version: v1.0
 */
public class nextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        while (head != null){
            A.add(head.val);
            head = head.next;
        }
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            int cur =  A.get(i);
            while (!stack.isEmpty() ){
                if(A.get(stack.peek()) < cur){
                    res[stack.pop()] = cur;
                }else break;
            }
            stack.push(i);
        }
        return res;

    }
}
