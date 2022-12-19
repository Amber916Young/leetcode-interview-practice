package ReWrite;

import java.util.*;

/**
 * @author birdyyoung
 * @ClassName:Soultion
 * @Description:
 * @Date: 17/12/2022 13:50
 * @Version: v1.0
 */
public class Soultion {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minAns =0;
        int minGap = Integer.MAX_VALUE;
        if (nums.length < 3) return minAns;
        for(int i = 0 ; i< nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int start = i + 1;
            int end  = nums.length-1;
            while (start < end){
                int sum3_closest = nums[i] + nums[start] + nums[end];
                int gap =  Math.abs(sum3_closest - target);
                if(gap < minGap ){
                    minGap = gap;
                    minAns = sum3_closest;
                }
                if (sum3_closest < target) {  //sum 大于 target
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                } else{
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                }
            }
        }
        return minAns;
    }
}
