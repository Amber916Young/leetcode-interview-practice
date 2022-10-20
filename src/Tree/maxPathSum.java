package Tree;

/**
 * @ClassName:maxPathSum
 * @Auther: yyj
 * @Description:
 * @Date: 20/10/2022 15:51
 * @Version: v1.0
 */
public class maxPathSum {



    //https://leetcode.com/problems/binary-tree-maximum-path-sum/
    int ans = Integer.MIN_VALUE;
    public int maxPathSum_DFS(TreeNode root){
        if(root == null) return 0;
        int right =  maxPathSum_DFS(root.right);
        int left =  maxPathSum_DFS(root.left);
        left = left < 0 ? 0 :left;
        right = right < 0 ? 0 :right;
        ans = Math.max(ans,left+right+root.val);
        return Math.max(left+root.val,right+root.val);

    }

    public int maxPathSum(TreeNode root) {
        maxPathSum_DFS(root);
        return ans;
    }

}
