package StringListHash;

import java.util.*;

/**
 * @ClassName:onesMinusZeros
 * @Auther: yyj
 * @Description:
 * @Date: 19/12/2022 22:48
 * @Version: v1.0
 */
public class onesMinusZeros {

    public static void main(String[] args) {
        onesMinusZeros(new int[][]{
                {1,1,1}
                ,{1,1,1}});
    }
    static public int[][] onesMinusZeros(int[][] grid) {
        List<Integer> onesRow = new ArrayList<>();
        List<Integer> onesCol = new ArrayList<>();
        List<Integer> zerosRow = new ArrayList<>();
        List<Integer> zerosCol = new ArrayList<>();

        for(int i = 0;i<grid.length;i++){
            int num = count(grid[i]);
            onesRow.add(num);
            zerosRow.add(grid[0].length - num);
        }
        for(int i = 0;i<grid[0].length;i++){
            int num = 0;
            for(int j = 0;j<grid.length;j++){
                num += grid[j][i];
            }
            onesCol.add(num);
            zerosCol.add(grid.length  - num);
        }


        //diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
        int[][] diff = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                diff[i][j] = onesRow.get(i) + onesCol.get(j) - zerosRow.get(i) - zerosCol.get(j);
            }
        }
        return diff;






    }

    private static int count(int[] arr){
        int num =0;
        for(int i = 0;i<arr.length;i++){
            num += arr[i];
        }
        return num;
    }
}
