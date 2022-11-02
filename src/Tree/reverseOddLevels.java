package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName:reverseOddLevels
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/
 * @Date: 01/11/2022 23:15
 * @Version: v1.0
 */
public class reverseOddLevels {


    //[2,5,3,21,34,8,13]
    public static void main(String[] args) {
        reverseOddLevels test = new reverseOddLevels();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left  = new TreeNode(5);
        treeNode.right  = new TreeNode(3);
        treeNode.left.right  = new TreeNode(34);
        treeNode.left.left  = new TreeNode(21);
        treeNode.right.left  = new TreeNode(8);
        treeNode.right.right  = new TreeNode(13);
        test.reverseOddLevels(treeNode);

    }
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        reverseOddLevels_DFS(root.left,root.right,1);
       return root;
    }

    private void reverseOddLevels_DFS(TreeNode root1, TreeNode root2, int depth) {
        if(root1==null || root2==null) return;
        if(depth % 2 !=0){
            int tmp = root1.val;
            root1.val = root2.val;
            root2.val = tmp;
        }
        reverseOddLevels_DFS(root1.left,root2.right,depth+1);
        reverseOddLevels_DFS(root1.right,root2.left,depth+1);
    }

}
