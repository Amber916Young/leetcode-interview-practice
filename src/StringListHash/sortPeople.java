package StringListHash;

import java.util.*;

/**
 * @ClassName:sortPeople
 * @Auther: yyj
 * @Description:
 * @Date: 18/12/2022 14:02
 * @Version: v1.0
 */
public class sortPeople {

    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int h1 = Integer.parseInt(o1[1]);
                int h2 = Integer.parseInt(o2[1]);
                return h2- h1;
            }
        });
        for(int i =0 ;i<names.length;i++){
            queue.add(new String[]{names[i],String.valueOf(heights[i])});
        }
        String[] ans = new String[names.length];
        int i=0;
        while (!queue.isEmpty()){
            ans[i++] = queue.poll()[0];
        }
        return ans;
    }
}
