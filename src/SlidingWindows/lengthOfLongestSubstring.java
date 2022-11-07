package SlidingWindows;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:lengthOfLongestSubstring
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @Date: 07/11/2022 23:05
 * @Version: v1.0
 */
public class lengthOfLongestSubstring {

    //3. Longest Substring Without Repeating Characters

    /***
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left =0,answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            while (!set.add(cur)) {
                char deleteChar = s.charAt(left);
                set.remove(deleteChar);
                left++;
            }
            answer = Math.max(answer, i - left + 1);
        }
        return answer;
    }
}
