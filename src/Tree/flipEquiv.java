package Tree;

/**
 * @ClassName:flipEquiv
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/flip-equivalent-binary-trees/
 * @Date: 01/11/2022 12:36
 * @Version: v1.0
 */
public class flipEquiv {


    //https://leetcode.com/problems/same-tree/ same
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2==null) return true;
        if(root1 == null || root2==null || root1.val != root2.val) return false;
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
