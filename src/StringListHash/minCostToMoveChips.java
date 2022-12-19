package StringListHash;

/**
 * @ClassName:minCostToMoveChips
 * @Auther: yyj
 * @Description:
 * @Date: 19/12/2022 12:58
 * @Version: v1.0
 */
public class minCostToMoveChips {
    public int minCostToMoveChips(int[] position) {
        int even_cnt = 0;
        int odd_cnt = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                even_cnt++;
            } else {
                odd_cnt++;
            }
        }
        return Math.min(odd_cnt, even_cnt);
    }
}
