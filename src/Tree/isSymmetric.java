package Tree;

/**
 * @ClassName:isSymmetric
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/symmetric-tree/
 * @Date: 30/10/2022 22:04
 * @Version: v1.0
 */
public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return isSymmetric_DFS(root.left, root.right);
    }

    private boolean isSymmetric_DFS(TreeNode left, TreeNode right) {
        if(left == null && right == null ) return true;
        if(left == null || right == null ) return false;
        return left.val == right.val && isSymmetric_DFS(left.right,right.left)&& isSymmetric_DFS(left.left,right.right);
    }
}
