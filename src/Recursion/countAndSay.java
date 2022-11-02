package Recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName:countAndSay
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/count-and-say/
 * @Date: 02/11/2022 22:29
 * @Version: v1.0
 */
public class countAndSay {

    public static void main(String[] args) {
        countAndSay say = new  countAndSay();
       System.out.println( say.countAndSay(4));
    }
    int end = 0;
    public String countAndSay(int n) {
        end = n;
        return countAndSay_DFS(n);
    }

    /**
     * Input: n = 4
     * Output: "1211"
     * countAndSay(1) = "1"
     * countAndSay(2) = say "1" = one 1 = "11"
     * countAndSay(3) = say "11" = two 1's = "21"
     * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
     * countAndSay(5) = say "1211" = one 1 + one 2 + two 1 = "11" + "12" + "21" = "111221"
     */
    private String countAndSay_DFS(int n) {
        if(n == 1) {
            return "1";
        }
        String s = countAndSay_DFS(n-1);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            } else{
                sb.append(count);
                sb.append(s.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
}
