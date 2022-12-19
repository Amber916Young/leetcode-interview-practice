package BinarySearch;

/**
 * @ClassName:judgeSquareSum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/sum-of-square-numbers/submissions/
 * @Date: 20/11/2022 19:19
 * @Version: v1.0
 */
public class judgeSquareSum {

    public boolean judgeSquareSum(int c) {
        long start = 0;
        long end = (long) Math.sqrt(c);
        long sum = (long) c;
        while (start <= end) {
            long mid = start * start + end * end;
            if (mid == sum) return true;
            else if (mid > sum)
                end--;
            else
                start++;
        }
        return false;
    }
}
