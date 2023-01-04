package Greedy;

import java.util.Arrays;

/**
 * @ClassName:findContentChildren
 * @Auther: yyj
 * @Description:
 * @Date: 30/12/2022 16:29
 * @Version: v1.0
 */
public class findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length){
            if (g[child]<= s[cookie]){
                child++;
            }
            cookie++;
        }

        return child;


    }
}
