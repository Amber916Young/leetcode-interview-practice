package Linklist;

/**
 * @ClassName:getDecimalValue
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @Date: 22/10/2022 23:49
 * @Version: v1.0
 */
public class getDecimalValue {

    /**
     *
     * Input: head = [1,0,1]
     * Output: 5
     * Explanation: (101) in base 2 = (5) in base 10
     * **/
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + (head.val == 1 ? 1 : 0);
            head = head.next;
        }
        return res;
    }
}
