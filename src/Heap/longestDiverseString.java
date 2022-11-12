package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName:longestDiverseString
 * @Auther: yyj
 * @Description:
 * @Date: 10/11/2022 23:41
 * @Version: v1.0
 */
public class longestDiverseString {

    public static void main(String[] args) {
        longestDiverseString(1,1,7);
    }
    static public String longestDiverseString(int a, int b, int c) {
        int[] count = new int[3];
        count[0] = a;
        count[1] = b;
        count[2] = c;


        StringBuilder sb = new StringBuilder();
        //逆序
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return count[o2 - 'a'] - count[o1 - 'a'];
            }
        });

        if (a > 0) pq.add('a');
        if (b > 0) pq.add('b');
        if (c > 0) pq.add('c');

        Character lastChar = null;

        while (!pq.isEmpty()) {
            Character s1 = pq.poll();
            Character s2 = pq.poll();

            if (count[s1 - 'a'] - 2 >= 0 && !(s1.equals(lastChar))) {
                sb.append(s1);
                sb.append(s1);
                count[s1 - 'a'] -= 2;
                lastChar = s1;
            } else {
                sb.append(s1);
                count[s1 - 'a'] -= 1;
                lastChar = s1;
            }
            if (s2 != null) {
                sb.append(s2);
                count[s2 - 'a'] -= 1;
                lastChar = s2;
            }else break;

            if (count[s1 - 'a'] > 0) pq.add(s1);
            if (count[s2 - 'a'] > 0) pq.add(s2);
        }
        return sb.toString();
    }


}
