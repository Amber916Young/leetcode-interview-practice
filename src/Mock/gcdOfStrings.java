package Mock;

import java.util.*;

/**
 * @ClassName:gcdOfStrings
 * @Auther: yyj
 * @Description:
 * @Date: 27/12/2022 16:00
 * @Version: v1.0
 */
public class gcdOfStrings {
    public static void main(String[] args) {
        gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM","NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM");
    }

   static public String gcdOfStrings(String str1, String str2) {

       Set<String> stringSet = new HashSet<>();

       for(int i = 0;i < str2.length(); i++){
           String s1 = str2.substring(i);
           String tmp = str1;
           if(str1.length() >= s1.length()){
               while ( tmp.length() > 0 ){
                   tmp = tmp.replaceAll(s1,"");
                   if(!tmp.contains(s1)) break;
               }
               if(tmp.isEmpty()){
                   stringSet.add(s1);
                   if(s1.length() == str1.length()) continue;
//                   return s1;
               }
           }
       }
        return "";

    }
}
