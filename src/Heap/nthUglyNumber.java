package Heap;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @ClassName:nthUglyNumber
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/ugly-number-ii/
 * @Date: 10/11/2022 13:44
 * @Version: v1.0
 */
public class nthUglyNumber {
    public static void main(String[] args) {
        nthUglyNumber(10);
    }
   static public int nthUglyNumber(int n) {
        int depth = 0;
       TreeSet<Long> queue = new TreeSet<>();
        queue.add((long)1);
       long ans = 0;
        while (depth++< n){
            long cur = queue.pollFirst();
            ans  = cur;
            if(depth == n) break;
            queue.add(cur * 2);
            queue.add(cur * 3);
            queue.add(cur * 5);
        }
        return (int) ans;
    }

}
