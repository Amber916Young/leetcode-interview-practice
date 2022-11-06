package StringListHash;

/**
 * @ClassName:isValid
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
 * @Date: 05/11/2022 18:52
 * @Version: v1.0
 */
public class isValid {


    public boolean isValid(String s) {

        while (s.indexOf("abc") != -1){
            s = s.replaceAll("abc","");
        }
        return s.equals("");
    }
}
