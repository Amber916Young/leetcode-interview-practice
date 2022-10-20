package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName:levelOrder
 * @Auther: yyj
 * @Description:
 * @Date: 20/10/2022 15:52
 * @Version: v1.0
 */
public class levelOrder {

    //https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                layer.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            res.add(layer);
        }
        return res;
    }
}
