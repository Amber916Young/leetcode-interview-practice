package StringListHash;
import java.util.*;

/**
 * @ClassName:fairCandySwap
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/fair-candy-swap/
 * @Date: 05/11/2022 22:04
 * @Version: v1.0
 */
public class fairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int SumA=0,SumB=0;
        Set<Integer> setB = new HashSet();
        for (int x: aliceSizes) SumA += x;
        for (int x: bobSizes) {
            SumB += x;
            setB.add(x);
        }
        int delta = (SumB-SumA)/2;
        for (int x: aliceSizes) {
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};
        }
        return new int[]{};

    }
}
