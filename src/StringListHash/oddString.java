package StringListHash;

import java.util.*;

/**
 * @ClassName:oddString
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/odd-string-difference/
 * @Date: 04/11/2022 14:16
 * @Version: v1.0
 */
public class oddString {

    public static void main(String[] args) {
        oddString(new String[]{"aaa","bob","ccc","ddd"});
    }

    static public String oddString(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> m = new HashMap<>();
        for (String s : words) {
            String str = "";
            for (int i = 1; i < s.length(); i++) {
                str += ((s.charAt(i) - 'a') - (s.charAt(i - 1) - 'a'))+" ";
            }
            m.put(str, s);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String s1 : map.keySet()) {
            if (map.get(s1) == 1) return m.get(s1);
        }
        return "";
    }
}
