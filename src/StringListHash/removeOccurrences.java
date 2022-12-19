package StringListHash;

import java.util.Stack;

/**
 * @ClassName:removeOccurrences
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 * @Date: 21/11/2022 13:01
 * @Version: v1.0
 */
public class removeOccurrences {

    int[] getLPS(String s, int n) {
        int i = 1, len = 0;
        int[] lps = new int[n];
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len == 0) {
                lps[i++] = 0;
            } else {
                len = lps[len - 1];
            }
        }
        return lps;
    }
    public String removeOccurrencesKMP(String str, String part) {
        int[] prefix = getLPS(part, part.length());
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        char[] p = part.toCharArray();
        char[] s = str.toCharArray();
        int[] idx = new int[s.length ];
        while (i < s.length) {
            if (s[i] == p[j]) {
                idx[i] = j + 1;
                stack.push(i);
                i++;
                j++;
                if (j == p.length) {
                    int cnt = p.length;
                    while (cnt > 0) {
                        stack.pop();
                        cnt--;
                    }
                    j = stack.isEmpty() ? 0 : idx[stack.peek()];
                }
            }  else if (j > 0) {
                j = prefix[j - 1];
            } else {
                stack.push(i);
                i++;
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(s[stack.pop()]);
        }
        return res.reverse().toString();
    }

    public String removeOccurrences(String s, String part) {
        while (s.indexOf(part)>-1){
            String tmp = s;
            int start = s.indexOf(part);
            int end = s.indexOf(part)+part.length();
            String s1 = tmp.substring(0,start);
            String s2 = tmp.substring(end);
            s = s1+s2;
        }
        return s;
    }
}


