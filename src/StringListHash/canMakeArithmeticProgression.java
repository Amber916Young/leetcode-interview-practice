package StringListHash;
import java.util.*;

/**
 * @ClassName:canMakeArithmeticProgression
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/
 * @Date: 19/12/2022 15:51
 * @Version: v1.0
 */
public class canMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int differ = arr[1] - arr[0];
        for (int j = 2;j< arr.length;j++){
            if(arr[j]-arr[j-1] != differ){
                return false;
            }
        }
        return true;
    }
}
