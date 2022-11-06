package StringListHash;

import java.util.*;

/**
 * @ClassName:longestPalindrome1
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-palindrome/?envType=study-plan&id=level-1
 * @Date: 06/11/2022 12:02
 * @Version: v1.0
 */
public class longestPalindrome1 {
    public static void main(String[] args) {
        longestPalindrome("abccccddd");
    }


    static public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c1 : chars) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }
        int ans = 0;
        List<Integer> list = new ArrayList();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cur = entry.getValue();
            if (cur % 2 == 0) {
                ans += cur;
            } else {
                list.add(cur - 1);
            }
        }
        if(list.size() == 0 ) return ans;
        for (Integer k : list) {
            ans += k;
        }
        return ans +1;
    }

}
