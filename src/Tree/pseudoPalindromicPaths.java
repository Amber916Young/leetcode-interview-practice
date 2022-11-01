package Tree;

import java.util.*;

/**
 * @ClassName:pseudoPalindromicPaths
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/
 * @Date: 01/11/2022 15:52
 * @Version: v1.0
 */
public class pseudoPalindromicPaths {


    public static void main(String[] args) {
        pseudoPalindromicPaths test = new pseudoPalindromicPaths();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left  = new TreeNode(3);
        treeNode.right  = new TreeNode(1);
        treeNode.left.right  = new TreeNode(1);
        treeNode.left.left  = new TreeNode(3);
        treeNode.right.right  = new TreeNode(1);
        test.pseudoPalindromicPaths(treeNode);

    }

    // TLE

    int ans = 0;
    List<ArrayList<Integer>> path = new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        pseudoPalindromicPaths_DFS(root, res);
        return ans;
    }
    public boolean checkPalindrom(ArrayList<Integer> nums) {
        int isPalindrom = 0;
        for (int i = 1; i < 10; ++i) {
            if (Collections.frequency(nums, i) % 2 == 1) {
                ++isPalindrom;
                if (isPalindrom > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    private void pseudoPalindromicPaths_DFS(TreeNode root,   List<Integer> res  ) {
        if(root==null) return;
        if(root.left == null && root.right == null ){
            res.add(root.val);
            if(checkPalindrom(new ArrayList<>(res))) ans++;
            return;
        }
        res.add(root.val);
        if(root.left != null){
            pseudoPalindromicPaths_DFS(root.left,res);
            res.remove(res.size()-1);
        }
        if(root.right != null){
            pseudoPalindromicPaths_DFS(root.right,res);
            res.remove(res.size()-1);
        }
    }
}
