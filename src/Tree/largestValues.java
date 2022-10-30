package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName:largestValues
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * @Date: 30/10/2022 22:51
 * @Version: v1.0
 */
public class largestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i =0;i<size;i++){
                TreeNode tmp = queue.poll();
                int val = tmp.val;
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
                max = Math.max(max,val);
            }
            res.add(max);
        }
        return res;

    }
}
