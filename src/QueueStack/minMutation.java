package QueueStack;

import java.util.*;

/**
 * @ClassName:minMutation
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-genetic-mutation/
 * @Date: 02/11/2022 12:16
 * @Version: v1.0
 */
public class minMutation {

    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;
        HashSet<String> bankMap = new HashSet<>(Arrays.asList(bank));
        if (!bankMap.contains(end)) return -1;
        Queue<String> queue = new LinkedList<>();
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        visited.add(start);
        queue.offer(start);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if(curr.equals(end)) return level;
                char[] currArray = curr.toCharArray();
                for(int k =0 ;k<currArray.length;k++){
                    char temp = currArray[k];
                    for(char c: charSet) {
                        currArray[k] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankMap.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[k] = temp;
                }
            }
            level++;
        }
        return -1;
    }
}
