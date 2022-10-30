package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName:maxDepth
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @Date: 30/10/2022 22:13
 * @Version: v1.0
 */
public class maxDepth {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth =0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }


    public int maxDepth_DFS(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth_DFS(root.left);
        int right = maxDepth_DFS(root.right);
        return Math.max(left,right) +1 ;
    }


}
