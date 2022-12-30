package StringListHash;
import java.util.*;

/**
 * @ClassName:findWinners
 * @Auther: yyj
 * @Description: 2225. Find Players With Zero or One Losses
 * @Date: 21/12/2022 16:25
 * @Version: v1.0
 */
public class findWinners {


    public static void main(String[] args) {
        findWinners(
                new int[][]{{1, 3},
                        {2, 3},
                        {3, 6},
                        {5, 6},
                        {5, 7},
                        {4, 5},
                        {4, 8},
                        {4, 9},
                        {10, 4},
                        {10, 9}});
    }
    static public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> losers = new HashMap<>();
        Set<Integer> winners = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] tmp : matches){
            int win = tmp[0];
            int lose = tmp[1];
            winners.add(win);
            losers.put(lose,losers.getOrDefault(lose,0)+1);
        }

        Set<Integer> loses = new TreeSet<>();
        for(Map.Entry<Integer,Integer> map : losers.entrySet()){
            int lose = map.getKey();
            winners.remove(lose);
            if(map.getValue() == 1){
                loses.add(lose);
            }
        }
        ans.add( new ArrayList<>(winners));
        ans.add( new ArrayList<>(loses));

        return ans;


    }
}
