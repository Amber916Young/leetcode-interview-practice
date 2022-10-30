package Tree;

/**
 * @ClassName:isBalanced
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/balanced-binary-tree/
 * @Date: 30/10/2022 22:25
 * @Version: v1.0
 */


public class isBalanced {


    //method 1
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return isBalanced_DFS(root)==-1? false: true;
    }
    int isBalanced_DFS(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = isBalanced_DFS(root.left);
        int r = isBalanced_DFS(root.right);
        if(l==-1 || r == -1){
            return -1;
        }
        if(Math.abs(l-r)>1){
            return -1;
        }
        return Math.max(l,r)+1;
    }
    //method 2

    public boolean isBalanced2(TreeNode root) {
        if(root==null) return true;
        int left = isBalanced_DFS2(root.left);
        int right = isBalanced_DFS2(root.right);
        if(Math.abs(left-right)>1) return false;
        return isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int isBalanced_DFS2(TreeNode root) {
        if(root == null) return 0;
        int left = isBalanced_DFS2(root.left);
        int right = isBalanced_DFS2(root.right);
        return Math.max(left,right) +1 ;
    }


}
