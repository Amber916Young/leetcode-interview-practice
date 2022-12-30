package StringListHash;
import java.util.*;

/**
 * @ClassName:findDuplicates
 * @Auther: yyj
 * @Description: 442. Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * @Date: 20/12/2022 15:28
 * @Version: v1.0
 */
public class findDuplicates {
    public static void main(String[] args) {
        findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }

  static   public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> ans = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        for(int i : nums){
//            if(set.contains(i)){
//                ans.add(i);
//            }
//            set.add(i);
//        }
//        return ans;


        List<Integer> res = new ArrayList();
        for(int n : nums){
            n = Math.abs(n);
            if(nums[n-1] > 0){
                nums[n-1] *= -1;
            } else {
                res.add(n);
            }
        }
        return res;
    }
}
