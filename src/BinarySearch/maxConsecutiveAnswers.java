package BinarySearch;

/**
 * @ClassName:maxConsecutiveAnswers
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 * @Date: 14/11/2022 14:53
 * @Version: v1.0
 */
public class maxConsecutiveAnswers {


    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int j = 0;
        int tmp = k;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (answerKey.charAt(i) == 'F') {
                tmp--;
            }
            while (tmp < 0) {
                if (answerKey.charAt(j) == 'F') tmp++;
                j++;
            }
            res = Math.max(res, i - j + 1);

        }
        j = 0;
        tmp = k;
        for (int i = 0; i < n; i++) {
            if (answerKey.charAt(i) == 'T') {
                tmp--;
            }
            while (tmp < 0) {
                if (answerKey.charAt(j) == 'T') tmp++;
                j++;
            }
            res = Math.max(res, i - j + 1);

        }
        return res;
    }
}
