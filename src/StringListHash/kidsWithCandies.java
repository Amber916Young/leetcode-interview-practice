package StringListHash;

import java.util.*;

/**
 * @ClassName:kidsWithCandies
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * @Date: 17/12/2022 14:26
 * @Version: v1.0
 */
public class kidsWithCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int n : candies){
            max = Math.max(max,n);
        }
        List<Boolean> res = new ArrayList<>();
        for(int n : candies){
            if(n+extraCandies >= max){
                res.add(true);
            }else {
                res.add(false);

            }
        }
        return res;
    }

}
