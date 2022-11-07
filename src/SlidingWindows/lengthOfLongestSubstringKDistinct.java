package SlidingWindows;

import java.util.*;

/**
 * @ClassName:lengthOfLongestSubstringKDistinct
 * @Auther: yyj
 * @Description:
 * @Date: 07/11/2022 22:38
 * @Version: v1.0
 */
public class lengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s,int k) {
        int left = 0, answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > k) {
                // 说明需要挪动left指针，map里要减去原指针位置的字符
                char deleteChar = s.charAt(left);
                int cur_num = map.get(deleteChar);
                if (cur_num - 1 == 0) map.remove(deleteChar);
                else map.put(deleteChar, cur_num - 1);
                //窗口右移
                left++;
            }
            // 获取窗口包含的字符个数,i-left +1 是窗口的大小
            answer = Math.max(answer, i - left + 1);
        }
        return answer;
    }

}
