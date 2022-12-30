package StringListHash;
import java.util.*;

/**
 * @ClassName:repeatedNTimes
 * @Auther: yyj
 * @Description:
 * @Date: 20/12/2022 14:23
 * @Version: v1.0
 */
public class repeatedNTimes {


    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i :nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(nums.length / 2 == entry.getValue()){
                return entry.getKey();
            }
        }
        return -1;


    }
}
