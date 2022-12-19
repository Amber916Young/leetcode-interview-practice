package StringListHash;

import java.util.*;

/**
 * @ClassName:wordPattern
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/word-pattern/
 * @Date: 20/11/2022 21:21
 * @Version: v1.0
 */
public class wordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<Character,String>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length)
            return false;
        for(int i=0; i <pattern.length(); i++){
            char pt = pattern.charAt(i);
            if(map.containsKey(pt)){
                if(!map.get(pt).equals(words[i]))
                    return false;
            }
            else{
                if(map.containsValue(words[i]))
                    return false;
                map.put(pt,words[i]);
            }
        }
        return true;
    }
}
