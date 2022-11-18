package BinarySearch;

/**
 * @ClassName:minSpeedOnTime
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 * @Date: 15/11/2022 19:23
 * @Version: v1.0
 */
public class minSpeedOnTime {
    public static void main(String[] args) {
        minSpeedOnTime speedOnTime = new minSpeedOnTime();

        speedOnTime.minSpeedOnTime( new int[]{1,3,2},2.7);
//        speedOnTime.minSpeedOnTime( new int[]{1,1,100000},2.01);
    }


    /**
     * Input: dist = [1,3,2], hour = 6
     * Output: 1
     * [1,3,2] 10
     * Output: 1
     * [1,3,2] 3
     *  Output: 3
     */
    public int minSpeedOnTime(int[] dist, double hour) {
        int start = 1;
        int end = 10000000;
        if((int)Math.ceil(hour) < dist.length) return -1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if(isPossible(mid, hour,dist)){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isPossible(int mid, double hour, int[] dist) {
        double speed = 0.0;
        for (int i =0;i<dist.length;i++){
            speed =Math.ceil(speed);
            speed += (dist[i] * 1.0) / (mid * 1.0);
        }
        return speed <= hour;
    }
}
