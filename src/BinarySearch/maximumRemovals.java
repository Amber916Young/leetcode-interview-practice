package BinarySearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:maximumRemovals
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-number-of-removable-characters/
 * @Date: 15/11/2022 22:37
 * @Version: v1.0
 */
public class maximumRemovals {

    public static void main(String[] args) {
        maximumRemovals speedOnTime = new maximumRemovals();
        speedOnTime.maximumRemovals( "abcacb","ab", new int[]{3,1,0});
    }


    public int maximumRemovals(String s, String p, int[] removable) {
        int start = 0;
        int end = removable.length;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(isPossible(mid, s ,p,removable)){
                start = mid + 1;
                ans = mid;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int mid, String s, String p, int[] removable) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for (int i=0; i < mid;i++){
            int remove_index = removable[i];
            set.add(remove_index);
        }
        for(int j=0;j<s.length();j++){
            if(!set.contains(j)){
                sb.append(s.charAt(j));
            }
        }
        // check is substr
        return isSubsequence(p,sb.toString());
    }

    // two pointers
    public boolean isSubsequence(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int j =0;
        for(int i = 0; i < t1.length; i++){
            if(j >=  s1.length) break;
            if(t1[i] == s1[j]) j++;
        }
        return j>=s1.length;
    }
}
