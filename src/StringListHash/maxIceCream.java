package StringListHash;

import java.util.Arrays;

/**
 * @ClassName:maxIceCream
 * @Auther: yyj
 * @Description: 1833. Maximum Ice Cream Bars
 * @Date: 25/12/2022 14:58
 * @Version: v1.0
 */
public class maxIceCream {

    public static void main(String[] args) {
        maxIceCream(new int[]{1,3,2,4,1},7);
    }
    static  public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i : costs) {
            if (coins - i < 0) {
                break;
            }
            coins -= i;
            count++;
        }
        return count;
    }
}
