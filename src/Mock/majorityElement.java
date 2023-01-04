package Mock;

import java.util.*;

/**
 * @ClassName:majorityElement
 * @Auther: yyj
 * @Description:
 * @Date: 01/01/2023 13:55
 * @Version: v1.0
 */
public class majorityElement {
    public static void main(String[] args) {
        majorityElement(new int[]{2,2,1,1,1,2, 3,2});
    }
    public List<Integer> majorityElement2(int[] nums) {
        int n = nums.length, nums1 = -1, nums2 = -1, count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums1) {
                count1++;
            } else if (nums[i] == nums2) {
                count2++;
            } else if (count1 == 0) {
                nums1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                nums2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums1) {
                count1++;
            } else if (nums[i] == nums2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            ans.add(nums1);
        }
        if (count2 > n / 3) {
            ans.add(nums2);
        }
        return ans;
    }
   static public List<Integer> majorityElement(int[] nums) {
       int times = nums.length / 3;
       Map<Integer, Integer> map = new HashMap<>();
       for (int i : nums) {
           map.put(i, map.getOrDefault(i, 0) + 1);
       }
       List<Integer> ans = new ArrayList<>();
       for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           if (entry.getValue() > times) {
               ans.add(entry.getKey());
           }
       }
       return ans;
   }
}
