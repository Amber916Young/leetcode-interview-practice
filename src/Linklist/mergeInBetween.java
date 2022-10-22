package Linklist;

/**
 * @ClassName:mergeInBetween
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/merge-in-between-linked-lists/
 * @Date: 22/10/2022 21:30
 * @Version: v1.0
 */
public class mergeInBetween {


    public static void main(String[] args) {
        mergeInBetween test = new mergeInBetween();
        ListNode node1 = new ListNode(0);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(2);
        node1.next.next.next = new ListNode(3);
        node1.next.next.next.next = new ListNode(4);
        node1.next.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1000000);
        node2.next = new ListNode(1000001);
        node2.next.next = new ListNode(1000002);
        test.mergeInBetween(node1,0,3,node2);
    }

    /**
     * Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
     * Output: [0,1,2,1000000,1000001,1000002,5]
     * Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place.
     * The blue edges and nodes in the above figure indicate the result.
     *
     * **/

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode subCurr = list2;
        ListNode curr = list1;
        int index = 0;

        if(index == a){
            while(index != b){
                list1 = list1.next;
                index++;
            }
            list1 = list1.next;
            curr = list1;
            ListNode nextNode = curr.next;
            curr.next = subCurr;
            while (subCurr.next != null){
                subCurr = subCurr.next;
            }
            subCurr.next = nextNode;
            return list1;
        }





        while (curr.next != null && curr != null){
            ListNode nextNode = curr.next;
            if((index+1) == a){
                curr.next = subCurr;
            }
            if(index == b){
                while (subCurr.next != null){
                    subCurr = subCurr.next;
                }
                subCurr.next = nextNode;
            }
            curr = nextNode;
            index++;
        }
        return list1;

    }
}
