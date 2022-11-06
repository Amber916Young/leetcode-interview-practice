package StringListHash;

import java.util.*;

/**
 * @ClassName:smallestSubsequence
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * @Date: 05/11/2022 19:21
 * @Version: v1.0
 */
public class smallestSubsequence {
    public static void main(String[] args) {
        smallestSubsequence("bcabc");

    }
    static public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            if (stack.contains(c)) continue;
            System.out.println(c);
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                char ch = stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder("");
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }



    //316. Remove Duplicate Letters
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        HashSet<Character> hs = new HashSet<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            if (hs.contains(c)) {
                continue;
            }
            while (st.size() > 0 && st.peek() > c && freq[st.peek() - 'a'] > 0) {
                char ch = st.pop();
                hs.remove(ch);
            }
            st.push(c);
            hs.add(c);
        }
        StringBuilder sb = new StringBuilder("");
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
