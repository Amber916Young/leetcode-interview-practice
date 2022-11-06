package StringListHash;

import java.util.List;
import java.util.Stack;

/**
 * @ClassName:maximumGain
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-score-from-removing-substrings/
 * @Date: 06/11/2022 12:51
 * @Version: v1.0
 */
public class maximumGain {

    public static void main(String[] args) {
        maximumGain("cdbcbbaaabab",4,5);
    }

    static public int maximumGain(String s, int x, int y) {
        int sum = 0;
        if(x > y){
            sum +=  maximumGain_stack(s,'a','b',x,y);
        }else
            sum =  maximumGain_stack(s,'b','a',y,x);
        return sum;
    }

    // cdbabcbbaaabab

    private static int maximumGain_stack(String s, char first, char second, int max, int min) {
        Stack<Character> stack = new Stack<>();
        String match =first+  "" + second ;
        int num = 0;
        for(int i =0;i<s.length();i++) {
            char curr = s.charAt(i);
            if (curr == first || curr == second) {
                if (!stack.isEmpty() && stack.peek() != curr) {
                    if (stack.peek() == first) {
                        num += max;
                        stack.pop();
                    }else stack.push(curr);
                } else {
                    stack.push(curr);
                }
            }else stack.push(curr);
        }
        if(stack.isEmpty()) return num;

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String newStr = sb.toString();

        for(int i = 0; i < newStr.length(); i++) {
            char curr = newStr.charAt(i);
            if (curr == first || curr == second) {
                if (!stack.isEmpty() && stack.peek() != curr) {
                    if (stack.peek() == first) {
                        num += min;
                        stack.pop();
                    }else stack.push(curr);
                } else {
                    stack.push(curr);
                }
            }else stack.push(curr);
        }
        return num;
    }


}
