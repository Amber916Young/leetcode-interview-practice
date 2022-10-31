package Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName:tree2str
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/construct-string-from-binary-tree/
 * @Date: 30/10/2022 22:57
 * @Version: v1.0
 */
public class tree2str {

    /**
     * Input: root = [1,2,3,4]
     * Output: "1(2(4))(3)"
     * Explanation: Originally, it needs to be "1(2(4)())(3()())",
     * but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
     *
     *           1
     *          /\
     *         2  3
     *        /
     *       4
     * **/

    public String tree2str(TreeNode root) {
        if(root == null) return  "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<>();
        while (!stack.isEmpty()){
            TreeNode tmp = stack.peek();
            if (!set.contains(tmp)) {
                set.add(tmp);
                sb.append("(" +tmp.val);
                if (tmp.left == null && tmp.right != null){
                    sb.append("()");
                }
                if(tmp.right != null){
                    stack.push(tmp.right);
                }
                if(tmp.left != null){
                    stack.push(tmp.left);
                }
            }else {
                stack.pop();
                sb.append(")");
            }
        }


        return sb.toString().substring(1,sb.toString().length()-1);
    }

}
