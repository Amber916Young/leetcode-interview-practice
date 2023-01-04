package Mock;

/**
 * @ClassName:checkRecord
 * @Auther: yyj
 * @Description:
 * @Date: 02/01/2023 13:03
 * @Version: v1.0
 */
public class checkRecord {
    public static void main(String[] args) {
        checkRecord("LALL");
    }
   static public boolean checkRecord(String s) {
       char[] chars = s.toCharArray();
       int len = s.length();
       int late = 0;
       int absent = 0;
       int pointer = 0;
       while (pointer < len) {
           char cur = chars[pointer++];
           if (cur == 'A') {
               absent++;
               late = 0;
               if (absent >= 2) {
                   return false;
               }
           } else if (cur == 'P') {
               late = 0;
           } else if (cur == 'L') {
               late++;
               if (late >= 3) {
                   return false;
               }
           }
       }
       return true;
   }
}
