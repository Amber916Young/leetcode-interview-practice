package BinarySearch;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName:maximumGroups
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/
 * @Date: 12/11/2022 22:25
 * @Version: v1.0
 */
public class maximumGroups {


    /**
     * Input: grades = [10,6,12,7,3,5]
     * Output: 3
     * Explanation: The following is a possible way to form 3 groups of students:
     * - 1st group has the students with grades = [12]. Sum of grades: 12. Student count: 1
     * - 2nd group has the students with grades = [6,7]. Sum of grades: 6 + 7 = 13. Student count: 2
     * - 3rd group has the students with grades = [10,3,5]. Sum of grades: 10 + 3 + 5 = 18. Student count: 3
     * It can be shown that it is not possible to form more than 3 groups.
     */
    public int maximumGroups(int[] grades) {
        int len = grades.length;
        int ans =(int) (Math.sqrt(1 + 8 * len) - 1) /2;
        return ans;
    }
}
