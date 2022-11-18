package Matrix;

import java.util.*;

/**
 * @ClassName:maximumDetonation2101
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/detonate-the-maximum-bombs/
 * @Date: 17/11/2022 23:39
 * @Version: v1.0
 */
public class maximumDetonation2101 {

    public static void main(String[] args) {
        //1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4
        maximumDetonation(new int[][]{{1,2,3},{2,3,1}
                ,{3,4,2}
                ,{4,5,3}
                ,{5,6,4}
        });
    }

    static public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long r = bombs[i][2];
                if (dx * dx + dy * dy <= r * r) {
                    List<Integer> list = graph.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    graph.put(i, list);
                }
            }
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int k : graph.get(cur)) {
                    if (visited.contains(k)) continue;
                    queue.add(k);
                    visited.add(k);
                }
            }
            ans = Math.max(ans, visited.size());
        }
        return ans;
    }
}
