package StringListHash;

/**
 * @ClassName:isSubsequence
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/is-subsequence/
 * @Date: 03/11/2022 11:18
 * @Version: v1.0
 */
public class isSubsequence {
    public static void main(String[] args) {
        isSubsequenceDP("aec","abcde");
    }


    static  public boolean isSubsequenceDP(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int n = s1.length;
        int m = t1.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1[i - 1] == t1[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[n][m] == s1.length;
    }
    // beats 100%
   static public boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int j =0;
        for(int i = 0; i < t1.length; i++){
            if(j >=  s1.length) break;
            if(t1[i] == s1[j]) j++;
        }
        return j>=s1.length;
    }
}
