package StringListHash;

import java.util.Stack;

/**
 * @author birdyyoung
 * @ClassName: validateStackSequences
 * @Description:
 * @Date: 25/12/2022 14:17
 * @Version: v1.0
 */
public class validateStackSequences {

    /***
     * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * Output: true
     * Explanation: We might do the following sequence:
     * push(1), push(2), push(3), push(4),
     * pop() -> 4,
     * push(5),
     * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     *
     *
     * pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
     *
     ***/
    public static void main(String[] args) {
        validateStackSequences(
                new int[]{1,2,3,4,5},  new int[]{4,3,5,2,1});
    }

   static public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i : pushed ){
            stack.add(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]){
                index++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
