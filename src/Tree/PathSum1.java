package Tree;

/**
 * @ClassName:PathSum1
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/path-sum/
 * @Date: 29/10/2022 23:33
 * @Version: v1.0
 */
public class PathSum1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if(root.val==targetSum && root.left==null && root.right==null){
            return true;
        }
        return hasPathSum(root.left ,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
