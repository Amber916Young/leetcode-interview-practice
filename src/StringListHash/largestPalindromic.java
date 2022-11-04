package StringListHash;
import java.util.*;

/**
 * @ClassName:largestPalindromic
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/largest-palindromic-number/
 * @Date: 03/11/2022 19:33
 * @Version: v1.0
 */
public class largestPalindromic {


    public static void main(String[] args) {
        largestPalindromic2("3333309");

    }


    static public String largestPalindromic2(String num) {
        int occ[] = new int[10];
        for (int i = 0; i < num.length(); i++) {
            occ[num.charAt(i) - '0']++;
        }
        StringBuilder first = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            // if occurance of digit is greater than one
            if (occ[i] > 1) {
                // Avoiding the leading zeros
                if (i == 0 && first.length() == 0)
                    continue;
                //Appending the even occurances of digits
                for (int j = 0; j < occ[i] / 2; j++)
                    first.append(i);
                occ[i] = occ[i] % 2;
            }
        }
        //Storing one digit at middle of resultant string
        String mid = "";
        for (int i = 9; i >= 0; i--) {
            if (occ[i] > 0) {
                mid += i;
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(first);
        res.append(mid);
        res.append(first.reverse());

        return res.toString();

    }

   static public String largestPalindromic(String num) {
       Map<Integer, Integer> map = new HashMap<>();
       for (char c : num.toCharArray()) {
           int cur = c - '0';
           map.put(cur, map.getOrDefault(cur, 0) + 1);
       }
       List<Integer> single = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
       boolean first = true;
       for (Map.Entry<Integer, Integer> mapSet : map.entrySet()) {
           int n = mapSet.getKey();
           int count = mapSet.getValue();
           if (count % 2 == 0) {
               while (count > 0) {
                   sb.insert(0, String.valueOf(n));
                   sb.insert(sb.length(), String.valueOf(n));
                   count--;
                   count--;
               }
           } else if (count == 1) {
               single.add(n);
           } else if (count % 2 != 0 && count > 1) {
               if(first){
                   while (count-- > 0) {
                       sb.insert(sb.length()/2, String.valueOf(n));
                   }
               }else {
                   count--;
                   while (count > 0) {
                       sb.insert(0, String.valueOf(n));
                       sb.insert(sb.length(), String.valueOf(n));
                       count--;
                       count--;
                   }
                   single.add(n);
               }
               first = false;
           }
       }
       if (single.size() != 0  ) {
           Collections.sort(single);
           if(sb.length() % 2 !=0 )
               sb.deleteCharAt(sb.length() / 2);
           sb.insert(sb.length() / 2, String.valueOf(single.get(single.size() - 1)));
       }
       String ans = sb.toString();



       String prefix = ans.substring( 0,ans.length() / 2);
       String last = ans.substring( ans.length() / 2);

       List<Character> characterList  = new ArrayList<>();

       for(int i =0;i<prefix.length();i++){
           characterList.add(prefix.charAt(i));
       }
       prefix = "";
       String prefix2 = "";
       Collections.sort(characterList);
       for(int i = characterList.size() -1; i>=0; i--){
           prefix += characterList.get(i);
           prefix2 +=  characterList.get(characterList.size() -1- i);
       }
       if(last.length() != prefix.length()){
           last = last.substring(0,1)+prefix2;
       }else {
           last = prefix2;
       }
       ans =  prefix+ last;


        boolean is0 = false;
       for (int i = 0; i < ans.length() / 2; i++) {
           if (ans.charAt(i) == '0' || ans.charAt(ans.length() - 1 -i) == '0') {
               if(ans.charAt(i) == '0' ) sb.deleteCharAt(0);
               if(ans.charAt(ans.length() - 1 -i) == '0')  sb.deleteCharAt(sb.length() - 1);
               is0 = true;
           }else{
               break;
           }
       }
       if(is0) ans = sb.toString();

       if(ans.equals("") ) return "0";



       return ans;
   }



}
