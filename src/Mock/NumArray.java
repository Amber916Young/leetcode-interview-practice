package Mock;

import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.ArrayList;
import java.util.*;

/**
 * @ClassName:NumArray
 * @Auther: yyj
 * @Description:
 * @Date: 02/01/2023 20:34
 * @Version: v1.0
 */
public class NumArray {
    public static void main(String[] args) {

        NumArray obj = new NumArray(new int[]{1, 3, 5});
        obj.update(0, 2);
        int param_2 = obj.sumRange(8, 2);
    }

    Map<Integer,Integer> map = new HashMap<>();
    Map<Integer,Integer> SumMap = new HashMap<>();

    public NumArray(int[] nums) {
        map = new HashMap<>();
        int total = 0;
        for(int i =0;i<nums.length;i++){
            map.put(i,nums[i] );
            total += nums[i];
            SumMap.put(i,total);
        }

    }
    public void update(int index, int val) {
        map.put(index, val);
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : SumMap.entrySet()) {
           if (entry.getKey() == index) {
               if(index == 0){
                   sum = val ;
               }else {
                   sum += SumMap.get(index -1) + val;
               }
               SumMap.put(entry.getKey() ,sum);
           }else if (entry.getKey() > index) {
                sum += map.get(entry.getKey());
                SumMap.put(entry.getKey() ,sum);
            }
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        if(left == 0){
            return SumMap.get(right);
        }
        int le = SumMap.get(left -1);
        int rig = SumMap.get(right);
//        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//            if(entry.getKey()>= left && entry.getKey() <= right){
//                sum += entry.getValue();
//            }
//            if( entry.getKey() >right){
//                break;
//            }
//
//        }
        return rig - le;
    }
}
