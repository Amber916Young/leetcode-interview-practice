package StringListHash;

import java.util.*;

/**
 * @ClassName:reorderLogFiles
 * @Auther: yyj
 * @Description:
 * @Date: 27/12/2022 14:38
 * @Version: v1.0
 */
public class reorderLogFiles {


    /**
     * "dig1 8 1 5 1",
     * "let1 art can",
     * "dig2 3 6",
     * "let2 own kit dig",
     * "let3 art zero"
     *
     * ["1 n u", "r 527", "j 893", "6 14", "6 82"]
     */
    public static void main(String[] args) {
        reorderLogFiles(new String[]{
                "j mo", "5 m w", "g 07", "o 2 0", "t q h"
        });
    }
    static public String[] reorderLogFiles(String[] logs) {
        List<String> res = new ArrayList<>();
        int index = 0;
        String[] ans = new String[logs.length];
        PriorityQueue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                String s1 = o1[1];
                String s2 = o2[1];
                if(s1.equals(s2)){
                    return  o2[0].compareTo(o1[0]);
                }
                return  s2.compareTo(s1) ;
            }
        });

        for(String log : logs){
            String identifier = log.split(" ")[0];
            String content = log.substring(log.indexOf(" ")+1);
            for(char c : content.replaceAll(" ","").toCharArray()){
                if(c >='0' && c <= '9'){
                    res.add(log);
                    break;
                }else {
                    queue.add(new String[]{identifier,content});
                    break;
                }
            }
        }

        while (!queue.isEmpty()){
            String[] strings = queue.poll();
            res.add(0,strings[0]+" "+strings[1]);
        }
        for (String s : res){
            ans[index++] = s;
        }
        return  ans;


    }
}
