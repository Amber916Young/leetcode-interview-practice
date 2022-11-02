package StringListHash;

import java.util.Locale;

/**
 * @ClassName:isPalindrome
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/valid-palindrome/
 * @Date: 02/11/2022 13:49
 * @Version: v1.0
 */
public class isPalindrome {

    public static void main(String[] args) {
        isPalindrome("8V8K;G;K;V;");
    }

    /**
     *
     Example 1:
     Input: s = "A man, a plan, a canal: Panama"
     Output: true
     Explanation: "amanaplanacanalpanama" is a palindrome.
     Example 2:

     Input: s = "race a car"
     Output: false
     Explanation: "raceacar" is not a palindrome.
     * @param s
     * @return
     */


   static public boolean isPalindrome(String s) {
       s = s.trim().toLowerCase();
       char[] chars = s.toCharArray();
       if (s.equals("") || s.length() == 1 ) return true;

       StringBuilder sb = new StringBuilder();
       for (char c : chars){
           if ((c >= '0' && c<= '9' ) || (c >= 'a' && c<= 'z' )){
               sb.append(""+c);
           }
       }
       chars = sb.toString().toCharArray();
       for(int i =0;i<chars.length;i++){
           if(chars[i] != chars[chars.length-1-i] ) return false;
       }

       return true;
   }
}
