package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:PathSum2
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/path-sum-ii/
 * @Date: 29/10/2022 23:33
 * @Version: v1.0
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root != null){
            findPathSum(root,targetSum,res,path);
        }
        return res;
    }
    private void findPathSum(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if(root==null) return;
        if(root.left == null && root.right == null && targetSum == root.val){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(root.val);
        if(root.left != null){
            findPathSum(root.left, targetSum-root.val, res, path);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            findPathSum(root.right, targetSum-root.val, res, path);
            path.remove(path.size()-1);
        }
    }
}
