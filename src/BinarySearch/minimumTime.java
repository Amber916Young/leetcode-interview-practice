package BinarySearch;

/**
 * @ClassName:minimumTime
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-time-to-complete-trips/
 * @Date: 15/11/2022 20:19
 * @Version: v1.0
 */
public class minimumTime {
    public static void main(String[] args) {
        minimumTime speedOnTime = new minimumTime();

        speedOnTime.minimumTime( new int[]{1},4);
//        speedOnTime.minSpeedOnTime( new int[]{1,1,100000},2.01);
    }

    /*
    Input: time = [1,2,3], totalTrips = 5
    Output: 3
     */
    public long minimumTime(int[] time, int totalTrips) {
        long start = 1;
        long end = Long.MAX_VALUE;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if(isPossible(mid, time ,totalTrips)){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isPossible(long mid, int[] time, int totalTrips) {
        long total = 0;
        for (int i : time){
            total += mid / i;
            if (total >= totalTrips) return true;
        }
        return false;
    }


}
