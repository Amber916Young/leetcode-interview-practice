package Heap;

/**
 * @ClassName:isUgly
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/ugly-number/
 * @Date: 10/11/2022 13:44
 * @Version: v1.0
 */
public class isUgly {
    public boolean isUgly(int num) {
        while (num >= 2) {
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else return false;
        }
        return num == 1;
    }
}
