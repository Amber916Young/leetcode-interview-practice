package Mock;

import java.util.*;

/**
 * @ClassName:distributeCandies
 * @Auther: yyj
 * @Description:
 * @Date: 02/01/2023 19:07
 * @Version: v1.0
 */
public class distributeCandies {


    public int distributeCandies(int[] candyType) {
        int eat_n = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int i : candyType){
            set.add(i);
        }

        if(set.size() == 1) return 1;
        if(set.size() >= eat_n) return eat_n;
        return set.size();
    }
}
