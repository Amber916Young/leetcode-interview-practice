package QueueStack;

import java.util.Stack;

/**
 * @ClassName:calculate2
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/basic-calculator-ii/
 * @Date: 02/11/2022 19:01
 * @Version: v1.0
 */
public class calculate2 {

    public static void main(String[] args) {
        calculate("42");
    }
   static public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                num = (num * 10) + (currentChar - '0');
            }
            //判断字符是否为空白字符
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-num);
                }
                else if (operation == '+') {
                    stack.push(num);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / num);
                }
                operation = currentChar;
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;




    }
}
