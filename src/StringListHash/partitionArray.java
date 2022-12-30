package StringListHash;

import java.util.*;

/**
 * @ClassName:partitionArray
 * @Auther: yyj
 * @Description: 2294. Partition Array Such That Maximum Difference Is K
 * @Date: 21/12/2022 20:43
 * @Version: v1.0
 */
public class partitionArray {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        /***
         * 1 2 3 5 6
         */
        int count = 0;
        int index = 0;
        for (int i = 1;i<nums.length;i++){
            if(nums[i] - nums[index] > k){
                count++;
                index = i;
            }
        }
        return count;



    }
}
