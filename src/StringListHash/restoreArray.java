//package StringListHash;
//
//import java.util.*;
//
///**
// * @ClassName:restoreArray
// * @Auther: yyj
// * @Description:
// * @Date: 22/12/2022 17:45
// * @Version: v1.0
// */
//public class restoreArray {
//    public static void main(String[] args) {
//        restoreArray(
//                new int[][]{{2, 1},
//                        {3, 4},
//                        {3, 2}});
//    }
//
//    static public int[] restoreArray(int[][] adjacentPairs) {
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        Map<Integer,Integer> head = new HashMap<>();
//
//        for(int[] pair : adjacentPairs){
//            int source = pair[0];
//            int dest = pair[1];
//            List<Integer> res = graph.getOrDefault(source,new ArrayList<>());
//            res.add(dest);
//            graph.put(source,res);
//
//            res = graph.getOrDefault(dest,new ArrayList<>());
//            res.add(source);
//            graph.put(dest,res);
//
//            head.put(source,head.getOrDefault(source,0)+1);
//            head.put(dest,head.getOrDefault(dest,0)+1);
//        }
//        Queue<Integer> queue = new ArrayDeque<>();
//
//        for(Map.Entry<Integer,Integer> entry : head.entrySet()){
//            if(entry.getValue() == 1){
//                queue.offer(entry.getKey());
//                break;
//            }
//        }
//        List<Integer> ans = new ArrayList<>();
//        boolean
//        while (!queue.isEmpty()){
//            int cur = queue.poll();
//            List<Integer> list = graph.get(cur);
//
//
//
//        }
//
//
//
//
//
//
//        return new int[]{};
//    }
//}
