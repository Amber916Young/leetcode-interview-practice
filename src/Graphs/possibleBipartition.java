package Graphs;

import java.util.*;

/**
 * @ClassName:possibleBipartition
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/possible-bipartition/
 * @Date: 31/10/2022 20:50
 * @Version: v1.0
 */
public class possibleBipartition {


    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0;i<dislikes.length;i++){
            int U = dislikes[i][0];
            int V = dislikes[i][1];
            graph[U].add(V);
            graph[V].add(U);
        }

        // only two color 0/1
        int[] coloring = new int[n+1];
        Arrays.fill(coloring,-1);
        for(int i =1;i<=n;i++){
            if(coloring[i] == -1){
                if(!isBipartition(graph,i,n,coloring)) return false;
            }
        }
        return true;
    }

    private boolean isBipartition(ArrayList<Integer>[] graph, int i, int n, int[] coloring) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        coloring[i] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int item : graph[curr]) {
                if (coloring[item] == coloring[curr]) return false; // odd
                if (coloring[item] == -1) { // unvisited
                    coloring[item] = 1 - coloring[curr];
                    queue.offer(item);
                }
            }
        }
        return true;
    }
}
