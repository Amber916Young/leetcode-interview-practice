package SlidingWindows;

import java.util.*;

/**
 * @ClassName:minWindow
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-window-substring/
 * @Date: 07/11/2022 23:48
 * @Version: v1.0
 */
public class minWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                if (map.get(curr) > 0) count++;
                map.put(curr, map.get(curr) - 1);
            }
            while (count == t.length()) {
                int windowSize = i - left + 1;
                if (windowSize < minLen) {
                    minLen = windowSize;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);

                    if (map.get(leftChar) == 0) count--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
