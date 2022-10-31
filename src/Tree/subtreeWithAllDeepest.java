package Tree;

/**
 * @ClassName:subtreeWithAllDeepest
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 * @Date: 31/10/2022 21:29
 * @Version: v1.0
 */
public class subtreeWithAllDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        int depth = getHeight(root);
        return lcaDeepestLeavesd_DFS(root,depth);
    }

    private TreeNode lcaDeepestLeavesd_DFS(TreeNode root, int depth) {
        if(root == null) return null;
        if(depth==1) return root;
        TreeNode left = lcaDeepestLeavesd_DFS(root.left, depth-1);
        TreeNode right = lcaDeepestLeavesd_DFS(root.right, depth-1);
        if(left!=null && right!=null){
            return root;
        }
        return left!=null? left: right;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

}
