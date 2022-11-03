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
        isSubsequence("aec","abcde");
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
