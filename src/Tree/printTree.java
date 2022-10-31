package Tree;

import java.util.*;

/**
 * @ClassName:printTree
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/print-binary-tree/
 * @Date: 30/10/2022 23:50
 * @Version: v1.0
 */
public class printTree {
    public static void main(String[] args) {
        printTree test = new printTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left  = new TreeNode(2);
        treeNode.right  = new TreeNode(3);
        treeNode.left.right  = new TreeNode(4);
        test.printTree(treeNode);

    }


    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        if(root == null) return ans;
        int height = getHeight(root);
        int width = (int)Math.pow(2,height)-1;
        List<String> row = new ArrayList<>();
        for(int i=0;i<width;i++) row.add("");
        for(int i=0;i<height;i++) ans.add(new ArrayList<String>(row));
        setRows(root, ans, 0, height, 0, width-1);
        return ans;
    }
    public void setRows(TreeNode root, List<List<String>> ans, int i, int height, int left, int right){
        if(i >= height || root == null) return;
        int mid = (left+right)/2;
        System.out.println(mid);
        ans.get(i).set(mid, String.valueOf(root.val));
        setRows(root.left, ans, i+1, height, left, mid-1);
        setRows(root.right, ans, i+1, height, mid+1, right);
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right) +1 ;
    }
}
