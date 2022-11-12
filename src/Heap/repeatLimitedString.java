package Heap;

import java.util.*;

/**
 * @ClassName:repeatLimitedString
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/construct-string-with-repeat-limit/
 * @Date: 11/11/2022 22:09
 * @Version: v1.0
 */
public class repeatLimitedString {
    public static void main(String[] args) {
//        repeatLimitedString("cczazccc",3);
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //Input: s = "cczazcc", repeatLimit = 3
        //Output: "zzcccac"

        PriorityQueue< Character> maxHeap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2.compareTo(o1);
            }
        });
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            maxHeap.offer(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char curr = maxHeap.poll();
            for(int i = 0;i<repeatLimit;i++){
                sb.append(curr);
                int num = map.get(curr);
                num--;
                map.put(curr,num);
                if(num == 0){
                    map.remove(curr);
                    break;
                }
            }
            if(map.containsKey(curr) && map.get(curr) > 0 && !maxHeap.isEmpty()){
                char curr2 = maxHeap.poll();
                sb.append(curr2);
                int num = map.get(curr2);
                num--;
                map.put(curr2,num);
                if(num != 0){
                    maxHeap.offer(curr2);
                }
                maxHeap.offer(curr);
            }
        }
        return sb.toString();
    }
}
