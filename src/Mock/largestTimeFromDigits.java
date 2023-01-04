package Mock;

import java.util.*;

/**
 * @ClassName:largestTimeFromDigits
 * @Auther: yyj
 * @Description:
 * @Date: 02/01/2023 20:04
 * @Version: v1.0
 */
public class largestTimeFromDigits {
    public static void main(String[] args) {
        largestTimeFromDigits test = new largestTimeFromDigits();
        test.largestTimeFromDigits(new int[]{1, 2, 3, 4});
    }

    PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    });

    public String largestTimeFromDigits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[arr.length];

        largestTimeFromDigits_DFS(arr, list, used, 0);

        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (Integer.parseInt(s.substring(0, 2)) < 24 && Integer.parseInt(s.substring(2)) < 60) {
                return s.substring(0, 2) + ":"+s.substring(2);
            }
        }
        return "";
    }

    private void largestTimeFromDigits_DFS(int[] arr, List<Integer> list, boolean[] used, int depth) {
        if (depth == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i);
            }
            System.out.println(sb.toString());
            queue.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue; //去重
            list.add(arr[i]);
            used[i] = true;
            largestTimeFromDigits_DFS(arr, list, used, depth + 1);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
