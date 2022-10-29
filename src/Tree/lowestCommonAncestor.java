package Tree;


/**
 * @ClassName:lowestCommonAncestor
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * 236. Lowest Common Ancestor of a Binary Tree
 * @Date: 20/10/2022 16:20
 * @Version: v1.0
 */
public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null) return null;
        if(root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null) return root;
        if(left == null && right == null) return null;

        return left != null ? left : right;
    }

}
