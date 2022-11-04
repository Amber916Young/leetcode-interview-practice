package QueueStack;

import java.util.Stack;

/**
 * @ClassName:longestValidParentheses
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-valid-parentheses/
 * @Date: 04/11/2022 19:20
 * @Version: v1.0
 */
public class longestValidParentheses {
    public static void main(String[] args) {
        longestValidParentheses("(()((())");
    }
    static public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    System.out.println(stack.peek());
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;


    }
}
