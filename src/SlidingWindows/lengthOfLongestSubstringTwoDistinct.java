package SlidingWindows;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:lengthOfLongestSubstringTwoDistinct
 * @Auther: yyj
 * @Description:
 * @Date: 07/11/2022 23:36
 * @Version: v1.0
 */
public class lengthOfLongestSubstringTwoDistinct {


    /***
     * Example 1:
     * Input: "eceba"
     * Output: 3
     * Explanation: t is "ece" which its length is 3.
     * Example 2:
     * Input: "ccaabbb"
     * Output: 5
     * Explanation: t is "aabbb" which its length is 5.
     * @param s
     * @return Longest Substring with At Most Two Distinct Characters
     */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > 2) {
                // 说明需要挪动left指针，map里要减去原指针位置的字符
                char deleteChar = s.charAt(left);
                int cur_num = map.get(deleteChar);
                if (cur_num - 1 == 0) map.remove(deleteChar);
                else map.put(deleteChar, cur_num - 1);
                left++;
            }
            // 获取窗口包含的字符个数,i-left +1 是窗口的大小
            answer = Math.max(answer, i - left + 1);
        }
        return answer;
    }
}
