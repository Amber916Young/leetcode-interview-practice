package SlidingWindows;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName:characterReplacement
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-repeating-character-replacement/
 * @Date: 08/11/2022 12:01
 * @Version: v1.0
 */
public class characterReplacement {
    public static void main(String[] args) {
        characterReplacement("AABABBA",1);

    }
   static public int characterReplacement(String s, int k) {
        int[] alp = new int[26];
        int len = s.length();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            alp[curr - 'A']++;
            while (i - left + 1 - getMaxCount(alp) > k) {
                // 意味着当前窗口包含了多余K个的字符
                // 收缩窗口
                //int window_size = i - left + 1;
                alp[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(i - left + 1, ans);
        }
        return ans;

    }

   static private int getMaxCount(int[] alp) {
        return Arrays.stream(alp).max().getAsInt();
    }
}
