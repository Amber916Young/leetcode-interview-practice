package BinarySearch;

import java.util.Arrays;

/**
 * @ClassName:countNegatives
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * @Date: 27/10/2022 13:02
 * @Version: v1.0
 */
public class countNegatives {
    public static void main(String[] args) {
        countNegatives(new int[][]{{4,-3,-2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}});
    }

    public static int countNegatives(int[][] grid) {
        int ans = 0;
        int n= grid.length, m = grid[0].length;
        for (int i =0 ;i< n ;i++){
            int l=0;
            int r = grid[i].length-1;
            int temp=-1;
            while(l<=r ){
                int mid=(l+r)/2;
                if(grid[i][mid]<0) {
                    temp = mid;
                    r=mid-1;
                } else{
                    l=mid+1;
                }
                System.out.print(ans);
            }
            if(temp!=-1) ans += (m-temp);
        }
        return ans;
    }
}
