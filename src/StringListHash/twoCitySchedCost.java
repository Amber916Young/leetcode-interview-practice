package StringListHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName:twoCitySchedCost
 * @Auther: yyj
 * @Description:
 * @Date: 25/12/2022 16:04
 * @Version: v1.0
 */
public class twoCitySchedCost {



    //[[20,40],[30,200],[400,50],[30,20]]
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int[] refund = new int[costs.length];
        for(int i =0;i<costs.length;i++){
            sum += costs[i][0];
            refund[i] = costs[i][1] - costs[i][0];

        }
        Arrays.sort(refund);
        for(int i=0;i<costs.length/2;i++){
            sum+=refund[i];
        }
        return  sum;


    }
}
