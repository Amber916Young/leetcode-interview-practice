package Mock;

import java.util.*;

/**
 * @ClassName:findCircleNum
 * @Auther: yyj
 * @Description:
 * @Date: 01/01/2023 19:19
 * @Version: v1.0
 */
public class findCircleNum {

    public static void main(String[] args) {

    }



    // isConnected = [[1,1,0],[1,1,0],[0,0,1]]

    // [1,1,0,1,0]
    // [1,1,0,1,0]
    // [0,0,1,0,1]
    // [1,1,0,1,0]
    // [0,0,0,0,1]

    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        boolean[] visited = new boolean[row];
        int count   =0;
        for(int i =0; i < row;i++){
            if(!visited[i]){
                count++;
                findCircleNum_DFS(isConnected,visited,i);
            }
        }
        return count;
    }

    private void findCircleNum_DFS(int[][] isConnected, boolean[] visited, int i) {
        for(int j = 0 ; j < isConnected.length ; j++){
            if(!visited[j] && isConnected[i][j] != 0){
                visited[j] = true;
                findCircleNum_DFS(isConnected,visited,j);
            }
        }
    }
}
