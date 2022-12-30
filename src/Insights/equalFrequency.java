package Insights;

import java.util.*;

/**
 * @ClassName:Insights
 * @Auther: yyj
 * @Description:
 * @Date: 28/12/2022 11:50
 * @Version: v1.0
 */
public class equalFrequency {
    public static void main(String[] args) {
        equalFrequency test = new equalFrequency();
        test.equalFrequency("aazz");
    }

    public boolean equalFrequency(String word) {
        int[] alp = new int[26];
        for(char c : word.toCharArray()){
            alp[c-'a']++;
        }
        Arrays.sort(alp);

        for(int i =0;i<26;i++){
            if(alp[i] == 0) continue;
            alp[i]--;
            if(checkIsValid(alp)){
                return true;
            }
            alp[i]++;

        }
        return false;
    }

    private boolean checkIsValid(int[] alp) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<26;i++){
            if(alp[i] == 0) continue;
            set.add(alp[i]);
        }
        return set.size() == 1;
    }
}
