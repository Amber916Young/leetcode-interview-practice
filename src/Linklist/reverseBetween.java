package Linklist;

import sun.tools.jstack.JStack;

import java.util.Stack;

/**
 * @ClassName:reverseBetween
 * @Auther: yyj
 * @Description:  https://leetcode.com/problems/reverse-linked-list-ii/
 * @Date: 25/10/2022 22:40
 * @Version: v1.0
 */
public class reverseBetween {

    public static void main(String[] args) {
        reverseBetween test = new  reverseBetween();

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(5);
        test.reverseBetween(node1,3,5);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return null;
        ListNode prev =null;
        ListNode current_node =head;
        while (left > 1){
            prev = current_node;
            current_node=  current_node.next;
            left--;
            right--;
        }
        ListNode connection = prev;
        ListNode tail = current_node;

        while (right > 0){
            ListNode next_node = current_node.next;
            current_node.next = prev;
            prev = current_node;
            current_node = next_node;
            right--;
        }
        if(connection != null){
            connection.next = prev;
        }
        tail.next = current_node;
        return head;



    }

}
