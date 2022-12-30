package StringListHash;

import java.util.*;

/**
 * @ClassName:maxCoins
 * @Auther: yyj
 * @Description:
 * @Date: 20/12/2022 13:19
 * @Version: v1.0
 */
public class maxCoins {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int coins = 0;
        int start = piles.length / 3;
        for(int i = start; i <= piles.length;i += 2){
            coins += piles[i];
        }
        return coins;

    }

}
