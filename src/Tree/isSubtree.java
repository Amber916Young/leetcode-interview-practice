package Tree;

/**
 * @ClassName:isSubtree
 * @Auther: yyj
 * @Description:
 * @Date: 20/10/2022 15:53
 * @Version: v1.0
 */
public class isSubtree {


    //https://leetcode.com/problems/subtree-of-another-tree/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSubtree_DFS(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSubtree_DFS(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == null && subRoot == null;
        return  root.val == subRoot.val && isSubtree_DFS(root.left,subRoot.left) && isSubtree_DFS(root.right,subRoot.right);
    }


}
