package Insights;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:isLongPressedName
 * @Auther: yyj
 * @Description:
 * @Date: 29/12/2022 15:36
 * @Version: v1.0
 */
public class isLongPressedName {
    public static void main(String[] args) {
        isLongPressedName("leelee","lleeeleeaae");
    }

    /**
     * "alex",
     * "aaleex"
     */
    static public boolean isLongPressedName(String name, String typed) {
        char[] name_char = name.toCharArray();
        char[] typed_char = typed.toCharArray();
        if (name_char.length > typed_char.length) {
            return false;
        }
        if (typed_char[typed_char.length - 1] != name_char[name.length() - 1] || typed_char[0] != name_char[0]) {
            return false;
        }
        int p1 =0 ;
        int p2 = 0;
        int len_name = name.length();
        int len_typed = typed.length();

        while ( p1 < len_name  && p2 < len_typed){
            if ( name_char[p1] == typed_char[p2] ){
                p1++;
                p2++;
            }else if (name_char[p1-1] == typed_char[p2]){
                p2++;
            }else{
                return false;
            }
        }

        while (p2 < len_typed){
            if ( name_char[p1-1] == typed_char[p2] ){
                p2++;
            }else{
                return false;
            }
        }
        return p1 == len_name;
    }
}
