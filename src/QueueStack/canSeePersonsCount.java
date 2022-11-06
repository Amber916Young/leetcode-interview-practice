package QueueStack;

import java.util.Stack;

/**
 * @ClassName:canSeePersonsCount
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 * @Date: 04/11/2022 23:10
 * @Version: v1.0
 */
public class canSeePersonsCount {


    public static void main(String[] args) {
        canSeePersonsCount(new int[]{11,19,12,15,14,18,7,1,8,9});
    }

    static public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            int visibility = 0;
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                visibility++;
            }
            if (!stack.isEmpty())
                visibility++;
            stack.push(heights[i]);
            result[i] = visibility;
        }
        return result;
    }



        // O(n^2)
   static public int[] canSeePersonsCount2(int[] heights) {
        int[] ans = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];
            int count = 0;
            int max = 0;
            for (int j = i + 1; j < heights.length; j++) {
                System.out.println(heights[j]);
                if(heights[j] <= cur)    {
                    if( heights[j] > max || (j-1)==i){
                        count++;
                        max = Math.max(max,heights[j]);
                    }
                } else {
                    count++;
                    break;
                }
            }
            ans[i] =  count;
        }
        return ans;

    }
}
