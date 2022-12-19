package StringListHash;

import java.util.*;

/**
 * @ClassName:isIsomorphic
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/isomorphic-strings/
 * @Date: 03/11/2022 10:33
 * @Version: v1.0
 */
public class isIsomorphic {
    public static void main(String[] args) {
        isIsomorphic("foo","bar");
    }
    static public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char k = t.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) != k ) {
                    return false;
                }
            } else {
                if (map.containsValue(k ))
                    return false;
                map.put(c, k);
            }
        }
        return true;
    }


    public boolean isIsomorphic2(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Character> set = new HashMap<>();
        Map<Character,Character>  set2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(set.containsKey(c1)){
                if(set.get(c1)!=c2) return false;
            }
            if(set2.containsKey(c2)){
                if(set2.get(c2)!=c1) return false;
            }
            set.put(c1,c2);
            set2.put(c2,c1);
        }
        return true;
    }
}
