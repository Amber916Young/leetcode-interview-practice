package StringListHash;

import java.util.*;

/**
 * @ClassName:validPalindrome2
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/valid-palindrome-ii/
 * @Date: 02/11/2022 14:25
 * @Version: v1.0
 */
public class validPalindrome2 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abbc"));

    }
    static public boolean isPalindrome(String s ,int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    static public boolean isPalindrome(String s) {
        for(int i =0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length() -1 -i)) return false;
        }
        return true;
    }
    static public boolean validPalindrome(String s) {
        int len = s.length() -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(len - i)){
                String s1 = s.substring(i+1,len - i +1);
                String s2 = s.substring(i,len - i);
                return isPalindrome(s1) ||isPalindrome(s2) ;
//                return isPalindrome(s,i+1, len - i) ||isPalindrome(s,i, len - i - 1) ;
            }
        }
        return true;
    }
}
