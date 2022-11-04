package StringListHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName:shiftingLetters2
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/shifting-letters-ii/
 * @Date: 04/11/2022 12:53
 * @Version: v1.0
 */
public class shiftingLetters2 {
    public static void main(String[] args) {
        shiftingLetters("abc",new int[][]{{0, 1, 0}, {1,2,1}, {0,2,1}});
    }

    /***
     * Input: s = "abc", shifts = [[0,2,0],[1,2,1],[0,2,1]]
     * Output: "ace"
     * Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
     * Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
     * Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".
     * @param s
     * @param shifts
     * @return
     */
   static public String shiftingLetters(String s, int[][] shifts) {
       int[] tmp = new int[s.length() + 1];
       for (int[] shift : shifts) {
           int value = shift[2] == 1 ? 1 : -1;
           tmp[shift[0]] += value;
           tmp[shift[1] + 1] -= value;
       }
       int sum = 0;
       char[] chars = s.toCharArray();
       for(int i=0;i<tmp.length-1;i++){
           sum += tmp[i];
           int n = ((chars[i]-'a')+sum) % 26;
           if(n<0) n += 26;
           chars[i] =  (char)('a'+n);
       }

       return String.valueOf(chars);


   }
}
