package Mock;

/**
 * @ClassName:sumOfLeftLeaves
 * @Auther: yyj
 * @Description:
 * @Date: 30/12/2022 16:55
 * @Version: v1.0
 */
public class sumOfLeftLeaves {
  public class TreeNode {
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

    int sum =0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if(root.left != null && (root.left.left == null && root.left.right == null)) {
            sum+=root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}
