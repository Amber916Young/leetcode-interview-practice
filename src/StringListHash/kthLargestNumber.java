package StringListHash;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName:kthLargestNumber
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 * @Date: 09/11/2022 23:52
 * @Version: v1.0
 */
public class kthLargestNumber {
    public static void main(String[] args) {
        kthLargestNumber(new String[]{"623986800","3","887298","695","794",
                "6888794705","269409","59930972","723091307","726368","8028385786","378585"},11);


    }
    static public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<String>(k, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length()!= b.length()?
                        a.length()- b.length(): a.compareTo(b);
            }
        });
        for(int i =0;i<nums.length;i++){
            queue.add(nums[i]);
            while (queue.size() > k){
                queue.poll();
            }
        }
        System.out.println(queue.peek());
        return queue.peek();
    }
}
