package Tree;

/**
 * @ClassName:treeQueries
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/
 * @Date: 02/11/2022 11:46
 * @Version: v1.0
 */
public class treeQueries {


    public static void main(String[] args) {
        treeQueries test = new treeQueries();
        TreeNode treeNode = new TreeNode(4);
        treeNode.left  = new TreeNode(8);
        treeNode.right  = new TreeNode(3);
        treeNode.left.right  = new TreeNode(0);
        treeNode.left.left  = new TreeNode(1);
        treeNode.right.left  = new TreeNode(6);
        treeNode.right.right  = new TreeNode(13);
//        [4,8,3,1,0,6,13]
        test.treeQueries(treeNode, new int[]{0,1,6});

    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length ;i++){
            TreeNode tmp = root;
            TreeNode newNode = deleteNode(tmp,queries[i]);
            ans[i] = treeQueries_getDepth(newNode);
        }
        return ans;
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null ) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val == key) {
            TreeNode minNode = root.right;
            while(minNode.left != null){
                minNode = minNode.left;
            }
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    private int treeQueries_getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeQueries_getDepth(root.right), treeQueries_getDepth(root.left)) + 1;
    }
}
