package SlidingWindows;

import java.util.Arrays;

/**
 * @ClassName:longestSubstring
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * @Date: 08/11/2022 21:11
 * @Version: v1.0
 */
public class longestSubstring {

    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }

    int longestSubstringUtil(String s, int start, int end, int k) {
        if (end < k) return 0;
        int[] countMap = new int[26];
        // update the countMap with the count of each character
        for (int i = start; i < end; i++)
            countMap[s.charAt(i) - 'a']++;

        for (int i = start; i < end; i++) {
            if (countMap[s.charAt(i) - 'a'] >= k) continue;
            int midNext = i + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) midNext++;
            return Math.max(longestSubstringUtil(s, start, i, k),
                    longestSubstringUtil(s, midNext, end, k));
        }
        return (end - start);
    }

}
