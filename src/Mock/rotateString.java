package Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:rotateString
 * @Auther: yyj
 * @Description:
 * @Date: 01/01/2023 13:36
 * @Version: v1.0
 */
public class rotateString {
    public static void main(String[] args) {
        rotateString("bbbacddceeb","ceebbbbacdd");
    }

//  "gcmbf"  abcde
//"fgcmb"  cdeab
    static public boolean rotateString(String s, String goal) {
        int len = s.length();
        if (len != goal.length()) {
            return false;
        }
        List<Integer> splitList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(goal.charAt(0) == s.charAt(i)){
                splitList.add(i);
            }
        }

        for(int splitIndex : splitList){
            if(splitIndex == 0){
                if(s.equals(goal)){
                    return true;
                }
            }
            String s1 = s.substring(0,splitIndex);
            String s2 = s.substring(splitIndex);
            String newStr = s2+s1;
            if(goal.equals(newStr)){
                return true;
            }
        }
        return false;


    }
}
