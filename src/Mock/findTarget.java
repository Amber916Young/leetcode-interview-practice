package Mock;


import java.util.*;

/**
 * @ClassName:findTarget
 * @Auther: yyj
 * @Description:
 * @Date: 27/12/2022 15:52
 * @Version: v1.0
 */
public class findTarget {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        return DFS_findTarget(root, k, new HashSet<>());
    }

    private boolean DFS_findTarget(TreeNode root, int target, Set<Integer> set) {
        if(root == null){
            return false;
        }
        int complement = target - root.val;
        if (set.contains(root.val)) {
            return true;
        }
        set.add(complement);
        return DFS_findTarget(root.left, target,set) ||
                DFS_findTarget(root.right, target,set);
    }
}
