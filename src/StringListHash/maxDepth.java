package StringListHash;

import java.util.Stack;

/**
 * @ClassName:maxDepth
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * @Date: 03/11/2022 21:15
 * @Version: v1.0
 */
public class maxDepth {
    public int maxDepth(String s) {
//        Stack<Character> stack = new Stack<>();
//        int max = 0;
//        for(int i =0 ;i<s.length();i++){
//            char curr = s.charAt(i);
//            if(curr=='('){
//                stack.push(curr);
//            } else if(curr==')'){
//                max= Math.max(max, stack.size());
//                stack.pop();
//            }
//        }
//        return max;


        int in = 0, max = 0;
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '('){
                in++;
                max = Math.max(max, in);
            } else if(s.charAt(i) == ')')
                in--;
        }
        return max;

    }

}
