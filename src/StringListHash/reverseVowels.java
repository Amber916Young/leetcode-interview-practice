package StringListHash;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:reverseVowels
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/reverse-vowels-of-a-string/
 * @Date: 04/11/2022 21:37
 * @Version: v1.0
 */
public class reverseVowels {

    public static void main(String[] args) {
        reverseVowels("hello");
    }

    static public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = new char[]{ 'a', 'e', 'i', 'o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<>();
        for(char c : chars) set.add(c);
        char[] ansChar = s.toCharArray();
        while (left < right){
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if(set.contains(c1) && set.contains(c2)){
                char tmp = ansChar[left];
                ansChar[left] = ansChar[right];
                ansChar[right] = tmp;
                left++;
                right--;
            }else if(set.contains(c1) &&  !set.contains(c2)){
                right--;
            }else if(!set.contains(c1) &&  set.contains(c2)){
                left++;
            }else {
                left++;
                right--;
            }
        }
        return  String.valueOf(ansChar);
    }
}
