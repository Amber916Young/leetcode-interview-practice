package Tree;

/**
 * @ClassName:isValidBST
 * @Auther: yyj
 * @Description:
 * @Date: 20/10/2022 15:58
 * @Version: v1.0
 */


//https://leetcode.com/problems/validate-binary-search-tree/
public class isValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root , null, null);
    }
    public boolean isValidBST(TreeNode root , Integer low, Integer high){
        if(root == null) return true;
        Integer num = root.val;
        if(low != null && low >= num) return false;
        if(high != null && high <= num) return false;
        return isValidBST(root.left, low, num) && isValidBST(root.right, num, high);
    }
}
