package Tree;

import java.util.*;

/**
 * @ClassName:zigzagLevelOrder
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * @Date: 30/10/2022 22:15
 * @Version: v1.0
 */
public class zigzagLevelOrder {
    // similar to levelOrder
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return  res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        boolean flag =false;
        while (!queue.isEmpty()){
            List<Integer> curList = new ArrayList<>();
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(level % 2==0){
                    flag=true;
                }else  flag =false;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                curList.add(node.val);
            }
            if(flag) {
                Collections.reverse(curList);
            }
            res.add(curList);
            level++;
        }
        return res;
    }
}
