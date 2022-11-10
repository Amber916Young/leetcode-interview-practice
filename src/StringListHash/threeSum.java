package StringListHash;

import java.util.*;

/**
 * @ClassName:threeSum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/3sum/
 * @Date: 08/11/2022 19:30
 * @Version: v1.0
 */
public class threeSum {
    public static void main(String[] args) {
        threeSum test = new threeSum();
        test.threeSum(new int[]{-1,0,1,2,-1,-4});
    }



    public List<List<Integer>> threeSum_twoPointer(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int target = 0;
        if (nums.length < 3) return res;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (threeSum > target) {
                    r--;
                    while (nums[r] == nums[r + 1] && l < r) r--;  // 去重
                } else if (threeSum < target) {
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) l++;   // 去重
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (nums[l] == nums[l - 1] && l < r) l++;
                    while (nums[r] == nums[r + 1] && l < r) r--;

                }
            }
        }
        return res;
    }

    // Recursion TLE
     List<List<Integer>> ans = new LinkedList<>();
      public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        threeSum_DFS(nums,res,0,0);
        return ans;
    }
    private void threeSum_DFS(int[] nums, List<Integer> res, int start,  int sum     ) {
        if(res.size() == 3 ) {
            if(sum == 0){
                if (!ans.contains(new ArrayList<>(res)))
                    ans.add(new ArrayList<>(res));
            }
            return;
        }
       if (start == nums.length) {
           return;
       }

       for (int i = start; i < nums.length; i++) {
           if(i > start && nums[i] == nums[i-1]) continue; // 去重
           res.add(nums[i]);
            threeSum_DFS(nums,res,i+1,sum + nums[i]);
            res.remove(res.size() - 1);
        }
    }
}
