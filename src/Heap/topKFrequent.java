package Heap;

import java.util.*;

/**
 * @ClassName:topKFrequent
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/top-k-frequent-elements/
 * @Date: 10/11/2022 13:23
 * @Version: v1.0
 */
public class topKFrequent {

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int x : nums) {
            seen.put(x, seen.getOrDefault(x, 0) + 1);
        }


        Comparator<Integer> comp2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {

                return seen.get(n2) -  seen.get(n1) ;
            }
        };
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<Integer>(comp2);

        for (Map.Entry<Integer, Integer> element : seen.entrySet()) {
            maxHeap2.add(element.getKey());
        }
        int[] topK = new int[k];
        for (int i = 0; i < topK.length; i++) {
            topK[i] = maxHeap2.poll();
        }
        return topK;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int x : nums) {
            seen.put(x, seen.getOrDefault(x, 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> n1, Map.Entry<Integer, Integer> n2) {
                return n2.getValue() - n1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(comp);
        for (Map.Entry<Integer, Integer> element : seen.entrySet()) {
            maxHeap.add(element);
        }
        int[] topK = new int[k];
        for (int i = 0; i < topK.length; i++) {
            Map.Entry<Integer, Integer> m = maxHeap.poll();
            topK[i] = m.getKey();
        }
        return topK;
    }
}