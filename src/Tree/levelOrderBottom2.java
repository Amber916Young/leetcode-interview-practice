package Tree;
import java.util.*;

/**
 * @ClassName:levelOrderBottom2
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @Date: 30/10/2022 22:23
 * @Version: v1.0
 */
public class levelOrderBottom2 {
    //similar to levelOrder  zigzagLevelOrder
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return  res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> curList = new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                curList.add(node.val);
            }
            res.add(curList);
        }
        Collections.reverse(res);
        return res;
    }
}
