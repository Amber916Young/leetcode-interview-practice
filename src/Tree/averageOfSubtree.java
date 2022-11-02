package Tree;

import java.util.*;

/**
 * @ClassName:averageOfSubtree
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 * @Date: 01/11/2022 23:58
 * @Version: v1.0
 */
public class averageOfSubtree {
    public static void main(String[] args) {
        averageOfSubtree test = new averageOfSubtree();
        TreeNode treeNode = new TreeNode(4);
        treeNode.left  = new TreeNode(8);
        treeNode.right  = new TreeNode(8);
        treeNode.left.right  = new TreeNode(0);
        treeNode.left.left  = new TreeNode(1);
        treeNode.right.left  = new TreeNode(6);
//        treeNode.right.right  = new TreeNode(13);
        test.averageOfSubtree(treeNode);

    }
    int count = 0; // variable to store answer.

    public int averageOfSubtree(TreeNode root) {
        averageOfSubtree_DFS(root);
        return count;
    }

    private int averageOfSubtree_DFS(TreeNode root ) {
        if(root==null) return 0;
        int leftN= averageOfSubtree_DFS(root.left);
        int rightN= averageOfSubtree_DFS(root.right);
        int sum= root.val;
        if(root.left!=null) sum+=root.left.val;
        if(root.right!=null) sum+=root.right.val;


        if(sum/(leftN+rightN+1)==root.val) count++;
        root.val=sum;
        return 1+leftN+rightN;
    }
}
