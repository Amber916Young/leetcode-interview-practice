package StringListHash;

import java.util.Stack;

/**
 * @ClassName:removeStars
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/removing-stars-from-a-string/
 * @Date: 04/11/2022 12:05
 * @Version: v1.0
 */
public class removeStars {

    public static void main(String[] args) {
        removeStars( "leet");
    }

    static public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            char cur = s.charAt(index++);
            if (stack.isEmpty()) {
                if (cur != '*') stack.push(cur);
                continue;
            }
            if (cur == '*') stack.pop();
            else stack.push(cur);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() != '*') {
                sb.insert(0, stack.pop());

            }
        }
        return sb.toString();

    }
}
