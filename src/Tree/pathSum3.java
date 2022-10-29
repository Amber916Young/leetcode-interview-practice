package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:pathSum3
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/path-sum-iii/
 * @Date: 29/10/2022 22:24
 * @Version: v1.0
 */
public class pathSum3 {
    public static void main(String[] args) {
        pathSum3 test = new pathSum3();
        TreeNode treeNode = new TreeNode(10);
        treeNode.left  = new TreeNode(5);
        treeNode.right  = new TreeNode(-3);

        treeNode.left.left  = new TreeNode(3);
        treeNode.left.right  = new TreeNode(2);
        treeNode.left .left.left = new TreeNode(3);
        treeNode.left.left.right  = new TreeNode(-2);
        treeNode.left.right.right  = new TreeNode(1);


        treeNode.right.right  = new TreeNode(11);


        test.pathSum(treeNode,8);

    }
    int res =0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> list= new ArrayList<>();
        findPathSum3(root, targetSum, 0, list);
        return res;
    }

    private void findPathSum3(TreeNode root, int targetSum, long temp, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        findPathSum3(root.left, targetSum, temp, list);
        findPathSum3(root.right, targetSum, temp, list);

        for (int i = list.size() - 1; i >= 0; i--) {
            temp += list.get(i);
            if (temp == targetSum) {
                res++;
            }
        }
        list.remove(list.size() - 1);
    }




}
