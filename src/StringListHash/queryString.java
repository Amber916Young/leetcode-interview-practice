package StringListHash;

/**
 * @ClassName:queryString
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
 * @Date: 05/11/2022 19:12
 * @Version: v1.0
 */
public class queryString {

    public boolean queryString(String s, int n) {
        while (n > 0) {
            String x = Integer.toBinaryString(n);
            if (!s.contains(x))
                return false;
            n--;
        }
        return true;
    }
}
