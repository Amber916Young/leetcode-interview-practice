package Heap;

import java.util.*;

/**
 * @ClassName:findRelativeRanks
 * @Auther: yyj
 * @Description:
 * @Date: 10/11/2022 14:14
 * @Version: v1.0
 */
public class findRelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        if(score.length==1) return new String[]{"Gold Medal"};
        int n = score.length;
        HashMap<Integer, Integer> map =new HashMap<>();
        PriorityQueue<Integer> minHeap =
                new PriorityQueue< Integer>(Collections.reverseOrder());
        for (int i = 0; i < n; i++){
            map.put(score[i],i);
            minHeap.offer(score[i]);
        }
        int i = 1;
        String[] answer = new String[n];
        while (!minHeap.isEmpty()) {
            int temp = minHeap.poll();
            int index = map.get(temp);
            if (i == 1) answer[index] = "Gold Medal";
            else if (i == 2) answer[index] = "Silver Medal";
            else if (i == 3) answer[index] = "Bronze Medal";
            else answer[index] = String.valueOf(i);
            i++;
        }
        return answer;
    }
}
