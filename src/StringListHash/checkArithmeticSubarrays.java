package StringListHash;
import java.util.*;

/**
 * @ClassName:checkArithmeticSubarrays
 * @Auther: yyj
 * @Description:
 * @Date: 19/12/2022 14:54
 * @Version: v1.0
 */
public class checkArithmeticSubarrays {


    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for(int i =0 ;i<m ; i++){
            int start = l[i];
            int end = r[i];
            int[] arr = new int[end - start + 1];
            int index = 0;
            for(int j = start; j<= end;j++){
                arr[index++] = nums[j];
            }
                ans.add(isTrue(arr));
        }
        return ans;

    }




  static  boolean isTrue( int[] arr ){
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
