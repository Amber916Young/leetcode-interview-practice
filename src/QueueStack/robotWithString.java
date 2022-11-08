package QueueStack;

import java.util.*;

/**
 * @ClassName:robotWithString
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
 * @Date: 06/11/2022 15:31
 * @Version: v1.0
 */
public class robotWithString {
    public static void main(String[] args) {
        robotWithString("bac");
    }

    static public String robotWithString(String s) {
        int n = s.length();
        int[] min = new int[n+1];
        min[n] = 25;
        for(int i=n-1;i>=0;i--)
            min[i] = Math.min(min[i+1], s.charAt(i)-'a');

        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            stack.push(ch);
            while(!stack.isEmpty() && stack.peek()-'a' <= min[i+1])
                sb.append(stack.pop());
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();

    }
}
