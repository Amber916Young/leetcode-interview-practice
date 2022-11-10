package Heap;
import java.util.*;

/**
 * @ClassName:topKFrequent692
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/top-k-frequent-words/
 * @Date: 10/11/2022 15:46
 * @Version: v1.0
 */
public class topKFrequent692 {

    /**
     * Given an array of strings words and an integer k, return the k most frequent strings.
     * Return the answer sorted by the frequency from highest to lowest.
     * Sort the words with the same frequency by their lexicographical order.
     * Example 1:
     *
     * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
     * Output: ["i","love"]
     * Explanation: "i" and "love" are the two most frequent words.
     * Note that "i" comes before "love" due to a lower alphabetical order.
     */
    public static void main(String[] args) {
        topKFrequent(new String[]{"aaa","the","day","day","day","day","is","sunny","the","the","the","sunny","is","is"},4);
    }

    static public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(map.get(a).equals(map.get(b)))
                    return a.compareTo(b);
                return map.get(b)-map.get(a);
            }
        };
        PriorityQueue<String> maxHeap = new PriorityQueue<String>(comp);
        for(Map.Entry<String,Integer> item : map.entrySet()){
            maxHeap.offer(item.getKey());
        }
        // test
        while (!maxHeap.isEmpty()){
            System.out.println(  maxHeap.poll());
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(maxHeap.poll());
        }
        return ans;


    }
}
