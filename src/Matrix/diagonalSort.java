package Matrix;

import java.util.*;

/**
 * @ClassName:diagonalSort
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/sort-the-matrix-diagonally/
 * @Date: 18/11/2022 15:09
 * @Version: v1.0
 */
public class diagonalSort {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};

        diagonalSort(mat);
    }
    static public int[][] diagonalSort(int[][] mat) {
        int row =mat.length,col =mat[0].length;

        for (int i = 0; i < col; i++) {
            int index = i;
            List<Integer> cache = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                if (index >= col) break;
                cache.add(mat[j][index++]);

            }
            Collections.sort(cache);
            index = i;
            for (int j = 0; j < row; j++) {
                if (index >= col) break;
                mat[j][index++] = cache.get(0);
                cache.remove(0);
            }
        }

        for (int i = 1; i < row; i++) {
            int index2 = i;
            List<Integer> cache2 = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                if (index2 >= row) break;
                cache2.add(mat[index2++][j]);

            }
            Collections.sort(cache2);
            index2 = i;
            for (int j = 0; j < col; j++) {
                if (index2 >= row) break;
                mat[index2++][j] = cache2.get(0);
                cache2.remove(0);
            }
        }
        return mat;
    }
}
