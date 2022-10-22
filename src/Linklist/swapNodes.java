package Linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:swapNodes
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @Date: 22/10/2022 23:13
 * @Version: v1.0
 */
public class swapNodes {

    /**
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [1,4,3,2,5]
     *
     * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
     * Output:       [7,9,6,6,8,7,3,0,9,5]
     * */

    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int t = list.get(k-1);
        int t2 = list.get(list.size()-k);
        list.set(k-1,t2);
        list.set(list.size()-k,t);
        ListNode ans = new ListNode(0);
        int index = 0;
        ListNode newNode = ans;
        while (index < list.size()){
            ListNode node =  new ListNode(list.get(index++));
            newNode.next = node;
            newNode = newNode.next;
        }

        return ans.next;






    }
}
