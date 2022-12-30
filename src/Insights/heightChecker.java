package Insights;

import java.util.Arrays;

/**
 * @ClassName:heightChecker
 * @Auther: yyj
 * @Description:
 * @Date: 29/12/2022 15:32
 * @Version: v1.0
 */
public class heightChecker {
    public int heightChecker(int[] heights) {

        int[] tmp = new int[heights.length];
        for(int i =0;i<heights.length;i++){
            tmp[i] = heights[i];
        }

        int count = 0;
        Arrays.sort(tmp);
        for(int i =0;i<heights.length;i++){
            if(tmp[i] != heights[i]){
                count++;
            }
        }
        return count;


    }

}
