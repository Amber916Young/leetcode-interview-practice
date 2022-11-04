package StringListHash;

import java.util.Arrays;

/**
 * @ClassName:shiftingLetters
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/shifting-letters/
 * @Date: 04/11/2022 12:28
 * @Version: v1.0
 */
public class shiftingLetters {
    public static void main(String[] args) {
        shiftingLetters("mkgfzkkuxownxvfvxasy",new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513});
    }

   static public String shiftingLetters(String s, int[] shifts) {
        int num =0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            num += shifts[i] % 26;
            shifts[i] = num % 26 ;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int cur = (chars[i]-'a' + shifts[i]) % 26;
            cur = cur +97;
            chars[i] =  (char)(cur);
        }
        return String.valueOf(chars);

    }
}
