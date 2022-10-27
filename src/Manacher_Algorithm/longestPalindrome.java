package Manacher_Algorithm;

/**
 * @ClassName:longestPalindrome
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-palindromic-substring/
 * @Date: 27/10/2022 20:49
 * @Version: v1.0
 */
public class longestPalindrome {
    public static void main(String[] args) {
        longestPalindrome("babads");
    }

    static String  getModifiedString(String s, int N){
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i = 0; i < N; i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String str = getModifiedString(s, s.length());
        int len = str.length();
        int rightSide = 0;
        int rightSideCenter = 0;
        int[] arr = new int[len];
        int center = 0;
        int longestHalf = 0;

        for (int i = 0; i < len; i++) {
            boolean needCalc = true;
            if (rightSide > i) {
                int leftCenter = 2 * rightSideCenter - i;
                arr[i] = arr[leftCenter];
                if (i + arr[i] > rightSide) {
                    arr[i] = rightSide - i;
                }
                if (i + arr[leftCenter] < rightSide) {
                    needCalc = false;
                }
            }
            if (needCalc) {
                while (i - 1 - arr[i] >= 0 && i + 1 + arr[i] < len) {
                    if (str.charAt(i - 1 - arr[i]) == str.charAt(i + 1 + arr[i])) {
                        arr[i]++;
                    } else break;
                }
            }

            rightSide = i + arr[i];
            rightSideCenter = i;
            if (arr[i] > longestHalf) {
                center = i;
                longestHalf = arr[i];
            }
        }

        int start = (center-longestHalf)/2; ;
        System.out.println(s.substring(start, start + longestHalf));
        return s.substring(start, start + longestHalf);


    }
}
