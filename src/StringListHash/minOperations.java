package StringListHash;

import java.util.*;

/**
 * @ClassName:minOperations
 * @Auther: yyj
 * @Description:
 * @Date: 19/12/2022 12:32
 * @Version: v1.0
 */
public class minOperations {
    public int[] minOperations(String boxes) {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < boxes.length(); i++) {
            map.put(i, boxes.charAt(i));
        }
        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int step = 0;

            for (Map.Entry<Integer, Character> set : map.entrySet()) {
                int index = set.getKey();
                char val = set.getValue();
                if (val == '1') {
                    step += Math.abs(i - index);
                }
            }
            ans[i] = step;
        }
        return ans;
    }

}
