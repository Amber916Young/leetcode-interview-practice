package Tree;

/**
 * @ClassName:evaluateTree
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/evaluate-boolean-binary-tree/
 * @Date: 27/10/2022 23:11
 * @Version: v1.0
 */
public class evaluateTree {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(1);
        evaluateTree(node);
    }
    /**
     * Leaf nodes have either the value 0 or 1,
     * where 0 represents False and 1 represents True.
     * Non-leaf nodes have either the value 2 or 3,
     * where 2 represents the boolean OR and 3 represents the boolean AND.
     *
     * **/
    static public boolean evaluateTree(TreeNode root) {
        return evaluateTree_DFS(root);
    }

    static private boolean evaluateTree_DFS(TreeNode root) {
        if(root.val == 0) return false;
        if(root.val == 1) return true;
        int option = root.val;
        if(option == 2) {
            return evaluateTree_DFS(root.left) || evaluateTree_DFS(root.right);
        }else
            return evaluateTree_DFS(root.left) && evaluateTree_DFS(root.right);

    }
}
