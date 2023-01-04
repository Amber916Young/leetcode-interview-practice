package Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:cutOffTree
 * @Auther: yyj
 * @Description:
 * @Date: 31/12/2022 15:40
 * @Version: v1.0
 */
public class cutOffTree {

    /**
     * [[54581641,64080174,24346381,69107959],
     * [86374198,61363882,68783324,79706116],
     * [668150,92178815,89819108,94701471],
     * [83920491,22724204,46281641,47531096],
     * [89078499,18904913,25462145,60813308]]
     * @param args
     */
    public static void main(String[] args) {
        cutOffTree test = new cutOffTree();
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(54581641);
        cur.add(64080174);
        cur.add(24346381);
        forest.add(cur);
        cur = new ArrayList<>();
        cur.add(0);
        cur.add(0);
        cur.add(0);
        forest.add(cur);
        cur = new ArrayList<>();
        cur.add(7);
        cur.add(6);
        cur.add(5);
        forest.add(cur);
        test.cutOffTree(forest);
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int row = forest.size();
        int col = forest.get(0).size();

        int[][] mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = forest.get(i).get(j);
            }
        }
        cutOffTree_DFS(0, 0, mat,mat[0][0]);

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j]< 0) {
                    count++;
                } else if (mat[i][j]> 0) {
                    return -1;
                }
            }
        }
        return count;
    }

    private void cutOffTree_DFS(int row_i, int col_j,  int[][]  forest,int prev) {
        int row = forest.length;
        int col = forest[0].length;
        if(row_i < 0 || col_j < 0 || row_i >= row || col_j >= col ||forest[row_i][col_j] <= 0 ) {
                return;
        }

        int curr =  forest[row_i][col_j];
        if(row_i != 0 || col_j !=0){
            if(curr < Math.abs(prev)) {
                return;
            }
        }
        forest[row_i][col_j]  *= -1;
        cutOffTree_DFS(row_i+1, col_j, forest,curr);
        cutOffTree_DFS(row_i-1, col_j, forest,curr);
        cutOffTree_DFS(row_i, col_j+1, forest,curr);
        cutOffTree_DFS(row_i, col_j-1, forest,curr);

    }
}
