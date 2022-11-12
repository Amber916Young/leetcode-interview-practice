package Heap;

import java.util.PriorityQueue;

/**
 * @ClassName:maximumScore
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-score-from-removing-stones/
 * @Date: 11/11/2022 18:31
 * @Version: v1.0
 */
public class maximumScore {

    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a1, a2) -> Integer.compare(a2, a1));
        max.add(a);
        max.add(b);
        max.add(c);
        int count = 0;
        int first = max.poll();
        int second = max.poll();
        while (first > 0 && second > 0) {
            max.add(first - 1);
            max.add(second - 1);
            first = max.poll();
            second = max.poll();
            count++;
        }
        return count;
    }
}
