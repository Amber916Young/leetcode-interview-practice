package StringListHash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName:countSubstrings
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/palindromic-substrings/
 * 647. Palindromic Substrings DP problem
 * @Date: 07/11/2022 00:01
 * @Version: v1.0
 */
public class countSubstrings {

    public static void main(String[] args) {
        countSubstrings test = new countSubstrings();
        test.countSubstrings("aaa");
    }

    /**
     *
     *
     * Example 1:
     * Input: s = "abc"
     * Output: 3
     * Explanation: Three palindromic strings: "a", "b", "c".
     *
     * Example 2:
     * Input: s = "aaa"
     * Output: 6
     * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
     * @param s
     * @return
     */


    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int len = chars.length;

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            count++;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {


            }
        }

        return count;
    }
}
