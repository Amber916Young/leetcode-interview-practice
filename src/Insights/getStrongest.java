package Insights;

import java.util.Arrays;

/**
 * @ClassName:getStrongest
 * @Auther: yyj
 * @Description:
 * @Date: 28/12/2022 14:10
 * @Version: v1.0
 */
public class getStrongest {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int med = arr[(n - 1) / 2];
        int[] res = new int[k];
        int low = 0;
        int high = n - 1;
        for (int i = 0; i < k; i++) {
            if (med - arr[low] <= arr[high] - med) {
                res[i] = arr[high];
                high--;
            } else {
                res[i] = arr[low];
                low++;
            }
        }
        return res;
    }
}
