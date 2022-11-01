package Tree;

/**
 * @ClassName:insertIntoMaxTree
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/maximum-binary-tree-ii/
 * @Date: 01/11/2022 13:52
 * @Version: v1.0
 */
public class insertIntoMaxTree {


    public static void main(String[] args) {
        insertIntoMaxTree test = new insertIntoMaxTree();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left  = new TreeNode(2);
        treeNode.right  = new TreeNode(3);
        treeNode.left.right  = new TreeNode(1);
//        treeNode.left.left  = new TreeNode(1);
//        treeNode.right.right  = new TreeNode(5);
        test.insertIntoMaxTree(treeNode,4);

    }


    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root != null && root.val > val){
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        TreeNode tree = new TreeNode(val);
        tree.left = root;
        return tree;
    }
}
