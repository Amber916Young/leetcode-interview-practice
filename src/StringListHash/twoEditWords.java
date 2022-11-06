package StringListHash;

import java.util.*;

/**
 * @ClassName:twoEditWords
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/words-within-two-edits-of-dictionary/
 * @Date: 04/11/2022 22:49
 * @Version: v1.0
 */
public class twoEditWords {
    public static void main(String[] args) {
        twoEditWords(new String[]{"word","note","ants","wood"},new String[]{"wood","joke","moat"});
    }


    /**
     * Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
     * Output: ["word","note","wood"]
     * @param queries
     * @param dictionary
     * @return
     */
   static public List<String> twoEditWords(String[] queries, String[] dictionary) {
       List<String> ans = new ArrayList<>();
       for(int i = 0;i<queries.length;i++){
            String cur = queries[i];
            char[]  curChar = cur.toCharArray();
            for(int j = 0;j<dictionary.length;j++){
                char[] chars = dictionary[j].toCharArray();
                int count = 0;
                for(int k =0;k<chars.length && count<=2 ;k++) {
                    if(curChar[k] != chars[k])count++;
                }
                if(count<=2){
                    ans.add( queries[i]);
                    break;
                }
            }
        }

       return ans;


    }
}
