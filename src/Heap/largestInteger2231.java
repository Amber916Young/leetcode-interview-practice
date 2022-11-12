package Heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName:largestInteger2231
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
 * @Date: 12/11/2022 08:48
 * @Version: v1.0
 */
public class largestInteger2231 {
    public static void main(String[] args) {
        largestInteger(1234);
    }

    static public int largestInteger(int num) {
        PriorityQueue<Integer> maxHeap_odd = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxHeap_even = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder( ) ;
        String s = String.valueOf(num);
        while (num > 0){
            int cur = num % 10;
            num /= 10;
            if( cur% 2==0){
                maxHeap_even.offer(cur);
            }else{
                maxHeap_odd.offer(cur);
            }
        }
        char c[] = s.toCharArray();
        for(int i = 0;i<c.length;i++){
            if(c[i]%2 == 0){
                sb.append(maxHeap_even.poll());
            }
            else{
                sb.append(maxHeap_odd.poll());
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
