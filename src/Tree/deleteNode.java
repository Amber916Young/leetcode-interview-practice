package Tree;

/**
 * @ClassName:deleteNode
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/delete-node-in-a-bst/
 * @Date: 29/10/2022 12:53
 * @Version: v1.0
 */
public class deleteNode {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null && root.left == null) {
                root = null;
                return root;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = root.right;
                while(minNode.left != null){
                    minNode = minNode.left;
                }
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
                return root;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);

        }
        return root;
    }

}
