package Tree;

/**
 * @ClassName:minDepth
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @Date: 30/10/2022 22:42
 * @Version: v1.0
 */
public class minDepth {

    /**
     * [3,9,20,null,null,15,7]
     * [2,null,3,null,4,null,5,null,6]
     * **/
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left==null && root.right==null) return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.right ==null) return left+1;
        if(root.left ==null) return right+1;
        return Math.min(left,right)+1;
    }
}
