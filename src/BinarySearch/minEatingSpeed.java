package BinarySearch;

/**
 * @ClassName:minEatingSpeed
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/koko-eating-bananas/
 * @Date: 05/11/2022 22:41
 * @Version: v1.0
 */
public class minEatingSpeed {
    public static void main(String[] args) {
        minEatingSpeed(new int[]{3,6,7,11},8);
    }

    //经典 一定要在h小时吃完香蕉 ， k是最小吃香蕉速度

    static public int minEatingSpeed(int[] piles, int h) {
        int left =1,right =1;
        for(int i =0;i<piles.length;i++){
            right = Math.max(right,piles[i]);
        }

        while (left < right){
            int mid = left + (right-left) / 2;
            int tmpEatSpeed = 0;
            for(int i =0;i<piles.length;i++){
                tmpEatSpeed += Math.ceil((double) piles[i] / mid);
            }
            if(tmpEatSpeed <= h) right = mid;
            else left = mid+1;
        }
        return right;
    }
}
