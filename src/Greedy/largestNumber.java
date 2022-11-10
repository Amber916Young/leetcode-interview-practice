package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName:largestNumber
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/largest-number/
 * @Date: 08/11/2022 20:41
 * @Version: v1.0
 */
public class largestNumber {

    public static void main(String[] args) {
        largestNumber(new int[]{0,0,34,5,9});
    }
    static private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    static public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}
