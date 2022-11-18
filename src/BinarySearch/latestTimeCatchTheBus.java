package BinarySearch;

import java.util.*;

/**
 * @ClassName:latestTimeCatchTheBus
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/the-latest-time-to-catch-a-bus/
 * @Date: 15/11/2022 23:41
 * @Version: v1.0
 */
public class latestTimeCatchTheBus {


    public static void main(String[] args) {
        latestTimeCatchTheBus speedOnTime = new latestTimeCatchTheBus();
        speedOnTime.latestTimeCatchTheBus( new int[]{20,30,10},new int[]{19,13,26,4,25,11,21},2);
    }
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0, ans = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < buses.length; i++) {
            int tmp_capacity = capacity;
            while (j < passengers.length && passengers[j] <= buses[i] && tmp_capacity > 0) {
                if (!set.contains(passengers[j] - 1))
                    ans = passengers[j] - 1;
                set.add(passengers[j]);
                j++;
                tmp_capacity--;
            }
            if (tmp_capacity > 0 && !set.contains(buses[i]))
                ans = buses[i];
        }
        return ans;
    }

}
