import java.util.*;

/**
 * @ClassName:test
 * @Auther: yyj
 * @Description:
 * @Date: 03/01/2023 13:59
 * @Version: v1.0
 */
public class test {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3};
        reArrange(new int[]{10,-1,20,4,5,-9,-6});
    }

    public static String[] findBin(int number) {
        String[] result = new String[number];
        // Write -- Your -- Code
        for(int i = 1; i <= number;i++){
            String s =  Integer.toBinaryString(i);
            result[i-1] = s;
        }

        return result; //For number = 3 , result = {"1","10","11"};
    }

    public static int findMaxSumSubArray(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return arr[0];
        int max = arr[0];
        int sum_cur = arr[0];
        for (int i =1;i<n;i++){
            sum_cur = Math.max(sum_cur + arr[i],arr[i]);
            if(sum_cur > max){
                max = sum_cur;
            }
        }
        return max;
    }
    public static void maxMin(int[] arr) {
        int temp[] = arr.clone();
        int start = 0;
        int end = arr.length -1;
        boolean flag = true;
        // Store result in temp[]
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                arr[i] = temp[end--];
            } else {
                arr[i] = temp[start++];
            }
            flag = !flag;
        }

    }

    public static void reArrange(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        while (start < end){
            if (arr[start] >= 0){
                if(arr[end] < 0){
                    int tmp = arr[end];
                    arr[end] =  arr[start];
                    arr[start] = tmp;
                }
                end--;
                continue;
            }
            start++;
        }
    }
}
