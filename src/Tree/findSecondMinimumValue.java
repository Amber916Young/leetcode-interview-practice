package Tree;

import java.util.*;

/**
 * @ClassName:findSecondMinimumValue
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * @Date: 31/10/2022 12:11
 * @Version: v1.0
 */
public class findSecondMinimumValue {
    public static void main(String[] args) {
        findSecondMinimumValue test = new findSecondMinimumValue();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left  = new TreeNode(4);
        treeNode.right  = new TreeNode(5);
        treeNode.left.right  = new TreeNode(1);
        treeNode.left.left  = new TreeNode(1);
        treeNode.right.right  = new TreeNode(5);
        test.findSecondMinimumValue(treeNode);

    }


    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new TreeSet<>();
        findSecondMinimumValue_DFS(root,set);
        if(set.size() == 1) return -1;
        set.remove(set.iterator().next());
        return set.iterator().next();
    }

    private void findSecondMinimumValue_DFS(TreeNode root, Set<Integer> set ) {
        if(root == null) return;
        set.add(root.val);
        findSecondMinimumValue_DFS(root.left,set);
        findSecondMinimumValue_DFS(root.right,set);
    }
}
