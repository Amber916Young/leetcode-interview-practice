package Tree;

import java.util.*;

/**
 * @ClassName:leafSimilar
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/leaf-similar-trees/
 * @Date: 01/11/2022 18:58
 * @Version: v1.0
 */
public class leafSimilar {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        leafSimilar_DFS(leaves1,root1);
        leafSimilar_DFS(leaves2,root2);
        return leaves1.equals(leaves2);

    }

    private void leafSimilar_DFS(List<Integer> leaves, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        leafSimilar_DFS(leaves, root.left);
        leafSimilar_DFS(leaves, root.right);
    }
}
