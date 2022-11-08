package SlidingWindows;

import java.util.*;

/**
 * @ClassName:numberOfSubstrings
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * @Date: 08/11/2022 15:13
 * @Version: v1.0
 */
public class numberOfSubstrings {

    public static void main(String[] args) {
        numberOfSubstrings("aaacb");
    }

    /**
     * Input: s = "abcabc"
     * Output: 10
     * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc",
     * "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
     *
     *
     * Input: s = "aaacb"
     * Output: 3
     * Explanation: The substrings containing at least one occurrence of
     * the characters a, b and c are "aaacb", "aacb" and "acb".
     * @param s
     * @return
     */
    static public int numberOfSubstrings(String s) {
        int left = 0, ans = 0;
        int[] arr = new int[3];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            arr[cur - 'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                ans += s.length()-i;
                //因为我们每个字符都有一次出现，所有大于它的字符串都会有这种情况，
                // 所以用长度减去current idx就可以得到所有可能有abc的字符串。
                arr[s.charAt(left++)-'a']--;
            }
        }
        return ans;
    }
}
