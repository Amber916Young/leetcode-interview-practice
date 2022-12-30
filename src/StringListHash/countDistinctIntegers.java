package StringListHash;

import java.util.*;

/**
 * @ClassName:countDistinctIntegers
 * @Auther: yyj
 * @Description:
 * @Date: 20/12/2022 12:28
 * @Version: v1.0
 */
public class countDistinctIntegers {
    public static void main(String[] args) {
       int[] ins =  new int[]{44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85
               ,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81};
        largestAltitude(ins);
    }


    static   public int largestAltitude(int[] gain) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(0);
        maxHeap.offer(gain[0]);
        int sum = 0;
        for (int i = 0; i < gain.length ; i++) {
            sum += gain[i];
            maxHeap.offer(sum);
        }
        return maxHeap.poll();

    }
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            int rev_i = Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());
            set.add(i);
            set.add(rev_i);
        }
        return set.size();

    }

    public boolean isSameAfterReversals(int num) {
        int rev_i = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
        int rev_i_twice = Integer.parseInt(new StringBuilder(String.valueOf(rev_i)).reverse().toString());
        return rev_i_twice == num;
    }



}
