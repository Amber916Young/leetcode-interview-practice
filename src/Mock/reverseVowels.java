package Mock;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName:reverseVowels
 * @Auther: yyj
 * @Description:
 * @Date: 02/01/2023 00:22
 * @Version: v1.0
 */
public class reverseVowels {
    public static void main(String[] args) {
        reverseVowels("ai");
    }

   static public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] chars = s.toCharArray();
        //"hElloxxxexxaiuxxx"
        while (start < end && start < s.length() ){
            if(!set.contains(chars[start])){
                start++;
            }else {
                if(set.contains(chars[end])){
                    char tmp =  chars[start];
                    chars[start] =  chars[end];
                    chars[end] = tmp;
                    end--;
                    start++;
                    continue;
                }
            }
            if(!set.contains(chars[end])){
                end--;
            }else {
                if(set.contains(chars[start])){
                    char tmp =  chars[start];
                    chars[start] =  chars[end];
                    chars[end] = tmp;
                    start++;
                    end--;
                }
            }
        }
//        System.out.println(String.valueOf(chars));
        return String.valueOf(chars);

    }
}
