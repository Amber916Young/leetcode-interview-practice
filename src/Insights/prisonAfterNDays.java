package Insights;

import java.util.Arrays;

/**
 * @ClassName:prisonAfterNDays
 * @Auther: yyj
 * @Description:
 * @Date: 29/12/2022 22:55
 * @Version: v1.0
 */
public class prisonAfterNDays {
    public static void main(String[] args) {
        prisonAfterNDays(new int[]{1,1,0,1,1,0,0,1},300663720);

    }
    static public int[] prisonAfterNDays(int[] cells, int n) {
        n =(n-1) % 14 + 1;
        for(int i =0; i < n;i++){
            int[] tmp = new int[cells.length];
            for(int j = 0 ;j<cells.length;j++){
                if(j==0 || j == cells.length-1){
                    if(cells[j] == 1){
                        tmp[j] = 0;
                    }
                    continue;
                }
                //0, 1, 0, 1, 1, 0, 0, 1
                if((cells[j-1] == 0 && cells[j+1] == 0)|| cells[j-1] == 1 && cells[j+1] == 1){
                    tmp[j] = 1;
                }else {
                    tmp[j] = 0;
                }
            }
            cells = tmp;
//            System.out.println(Arrays.toString(Arrays.stream(cells).toArray()));
        }
        return cells;
    }
}
