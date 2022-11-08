package QueueStack;

import java.util.Stack;

/**
 * @ClassName:countCollisions
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/count-collisions-on-a-road/
 * @Date: 06/11/2022 19:56
 * @Version: v1.0
 */
public class countCollisions {
    public static void main(String[] args) {
        countCollisions("LLRLRLLSLRLLSLSSSS");

    }

    /**
     * Input: directions = "RSLRSLL"
     * Output: 5
     * Explanation:
     * The collisions that will happen on the road are:
     * - Cars 0 and 1 will collide with each other. Since they are moving in opposite directions, the number of collisions becomes 0 + 2 = 2.
     * - Cars 2 and 3 will collide with each other. Since car 3 is stationary, the number of collisions becomes 2 + 1 = 3.
     * - Cars 3 and 4 will collide with each other. Since car 3 is stationary, the number of collisions becomes 3 + 1 = 4.
     * - Cars 4 and 5 will collide with each other. After car 4 collides with car 3, it will stay at the point of collision and get hit by car 5. The number of collisions becomes 4 + 1 = 5.
     * Thus, the total number of collisions that will happen on the road is 5.
     * @param directions
     * @return
     *
     * LLRLRLLSLRLLSLSSSS
     */
   static public int countCollisions(String directions) {
       int left=0;
       int right=directions.length()-1;
       for(int i = 0;i<directions.length();i++){
           if( directions.charAt(i)=='L') left++;
           else break;

       }
       for(int i = directions.length() -1;i>=0;i--){
           if( directions.charAt(i)=='R') right--;
           else break;

       }
       int count=0;
       for(int i=left;i<=right;i++){
           if(directions.charAt(i)!='S'){
               count++;
           }
       }
       return count;
    }
}
