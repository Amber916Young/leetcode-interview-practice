package Mock;

import java.util.*;

/**
 * @ClassName:networkDelayTime
 * @Auther: yyj
 * @Description:
 * @Date: 02/01/2023 13:20
 * @Version: v1.0
 */
public class networkDelayTime {
    //[[2,1,1],[2,3,1],[3,4,1]]
    public static void main(String[] args) {
        networkDelayTime(new int[][]{
                {2,1,1}
                ,{2,3,1}
                ,{3,4,1}},4,2);
    }

  static   public int networkDelayTime(int[][] times, int n, int k) {
      Map<Integer, List<int[]>> graph = new HashMap<>();
      for (int[] net : times) {
          int source = net[0];
          int target = net[1];
          int weight = net[2];
          List<int[]> list = graph.getOrDefault(source, new LinkedList<int[]>());
          list.add(new int[]{target, weight});
          graph.put(source, list);
      }
      PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
              return o1[1] - o2[1];
          }
      });
      if (graph.containsKey(k)) {
          queue.add(new int[]{k, 0});
      } else {
          return -1;
      }
      Set<Integer> visited = new HashSet<>();
      int count = Integer.MAX_VALUE;
      while (!queue.isEmpty()) {
          int[] tmp = queue.poll();
          int node = tmp[0];
          int weight = tmp[1];
          if (visited.contains(node)) continue;
          visited.add(node);
          count = weight;
          if (graph.containsKey(node)) {
              List<int[]> list = graph.get(node);
              for (int[] ints : list) {
                  int node_t = ints[0];
                  int weight_t = ints[1];
                  if (visited.contains(node_t)) continue;
                  queue.add(new int[]{node_t, weight + weight_t});
              }
          }
      }
      return visited.size() == n? -1 : count;
  }
}
