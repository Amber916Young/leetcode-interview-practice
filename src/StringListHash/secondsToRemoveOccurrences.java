package StringListHash;

/**
 * @ClassName:secondsToRemoveOccurrences
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/
 * @Date: 04/11/2022 11:52
 * @Version: v1.0
 */
public class secondsToRemoveOccurrences {
    public static void main(String[] args) {
        secondsToRemoveOccurrences("0110101");
    }

   static public int secondsToRemoveOccurrences(String s) {
       if(s.indexOf("01") == -1) return 0;
        int count = 1;
        while (true){
            s = s.replaceAll("01","10");
            if(s.indexOf("01") == -1) break;
            count++;
        }
        return count;
    }
}
