package Tree;

/**
 * @ClassName:insertIntoBST
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * @Date: 01/11/2022 13:50
 * @Version: v1.0
 */
public class insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        if(val>root.val){
            root.right = insertIntoBST(root.right,val);
        }else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;

    }
}
