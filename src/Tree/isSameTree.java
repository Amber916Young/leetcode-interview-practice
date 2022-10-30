package Tree;

/**
 * @ClassName:isSameTree
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/same-tree/
 * @Date: 30/10/2022 22:09
 * @Version: v1.0
 */
public class isSameTree {
    //similar to symmetric tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null ) return true;
        if(p == null || q == null ) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
