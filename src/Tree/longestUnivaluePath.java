package Tree;

/**
 * @ClassName:longestUnivaluePath
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-univalue-path/solution/
 * @Date: 31/10/2022 11:37
 * @Version: v1.0
 */
public class longestUnivaluePath {

    public static void main(String[] args) {
        longestUnivaluePath test = new longestUnivaluePath();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left  = new TreeNode(4);
        treeNode.right  = new TreeNode(5);
        treeNode.left.right  = new TreeNode(1);
        treeNode.left.left  = new TreeNode(1);
        treeNode.right.right  = new TreeNode(5);
        test.longestUnivaluePath(treeNode);

    }

    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);

        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
