package StringListHash;

import java.util.*;

/**
 * @ClassName:countGoodTriplets
 * @Auther: yyj
 * @Description:
 * @Date: 19/12/2022 13:55
 * @Version: v1.0
 */
public class countGoodTriplets {
    public static void main(String[] args) {
        countGoodTriplets(new int[]{7,3,7,3,12,1,12,2,3},5,8,1);
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int sum = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i+1; j < arr.length -1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(Math.abs(arr[i]-arr[j])<=a && Math.abs(arr[j]-arr[k])<=b
                            && Math.abs(arr[i]-arr[k])<=c){
                        sum++;
                    }

                }
            }
        }
        return sum;

    }
}
