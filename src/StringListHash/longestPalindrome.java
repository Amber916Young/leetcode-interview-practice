package StringListHash;

import java.util.*;

/**
 * @ClassName:longestPalindrome
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 * @Date: 03/11/2022 11:33
 * @Version: v1.0
 */
public class longestPalindrome {

    public static void main(String[] args) {
        longestPalindrome(new String[]{"lc","cl","gg"});
    }
   static public int longestPalindrome(String[] words) {
       HashMap<String , Integer>  map = new HashMap<>();
       for (String s : words) {
           map.put(s,map.getOrDefault(s,0)+1);
       }
       int answer = 0;
       boolean central = false;
       for (Map.Entry<String, Integer> entry : map.entrySet()) {
           String word = entry.getKey();
           int count = entry.getValue();
           if (word.charAt(0) == word.charAt(1)) {
               if (count % 2 == 0) {
                   answer += count;
               } else {
                   answer += count - 1;
                   central = true;
               }
           }else if (word.charAt(0) > word.charAt(1)) {
               String reversedWord = "" + word.charAt(1) + word.charAt(0);
               if (map.containsKey(reversedWord)) {
                   answer += 2 * Math.min(count, map.get(reversedWord));
               }
           }
       }
       return central ? (answer+1)*2 : answer * 2;
   }


}
