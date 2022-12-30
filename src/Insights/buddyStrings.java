package Insights;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:buddyStrings
 * @Auther: yyj
 * @Description:
 * @Date: 29/12/2022 13:28
 * @Version: v1.0
 */
public class buddyStrings {
    public static void main(String[] args) {
        buddyStrings test = new buddyStrings();
        test.buddyStrings("abac","abad");
    }

    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] gArray = goal.toCharArray();

        if(s.equals(goal)  ){
            if(s.chars().distinct().count() != s.length()){
                return true;
            }else{
                return false;
            }
        }

        int l = 0, r = s.length() - 1;
        while (sArray[l] == gArray[l] && l < r) {
            l++;
        }
        while (sArray[r] == gArray[r] && l < r) {
            r--;
        }
        char tmp = sArray[l];
        sArray[l] = sArray[r];
        sArray[r] = tmp;

        while (l <= r){
            if(sArray[l] != gArray[l] || sArray[r] != gArray[r] ){
                return false;
            }
            l++;
            r--;
        }

        return true;





    }


}
