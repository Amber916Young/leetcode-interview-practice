package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:getDirections
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * @Date: 01/11/2022 22:52
 * @Version: v1.0
 */
public class getDirections {
    public static void main(String[] args) {
        getDirections test = new getDirections();
        TreeNode treeNode = new TreeNode(2);
        treeNode.left  = new TreeNode(5);
        treeNode.right  = new TreeNode(3);
        treeNode.left.right  = new TreeNode(34);
        treeNode.left.left  = new TreeNode(21);
        treeNode.right.left  = new TreeNode(8);
        treeNode.right.right  = new TreeNode(13);
        test.getDirections(treeNode,21,8);

    }
    List<List<TreeNode>> ans = new ArrayList<>();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> list = new ArrayList<>();
        getDirections_DFS(root,startValue,list);
        list = new ArrayList<>();
        getDirections_DFS(root,destValue,list);

        List<TreeNode> path1 = ans.get(0);
        List<TreeNode> path2 = ans.get(1);

        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while(i >= 0 && j >= 0 && path1.get(path1.size() - 1 - i).val == path2.get( path2.size() - 1-j).val){
            System.out.println(path1.get(  path1.size() - 1-i).val);
            System.out.println(path2.get( path2.size() - 1-j).val);
            i--;
            j--;
        }

        StringBuilder res = new StringBuilder();
        while(i >= 0){  //As we have to move Up from startValue to LCA, so we will append 'U'
            res.append("U");
            i--;
        }

        TreeNode tempRoot = path2.get(j); //LCA
        while(j >= 0){
            TreeNode currNode = path2.get(j); // current node
            if(tempRoot.left == currNode){ //checking whether this node is left or right child of current node
                res.append("L");
            }else{
                res.append("R");
            }

            tempRoot = currNode; //change the temp root node as current node, for next node
            j--;
        }

        return res.toString();
    }

    private void getDirections_DFS(TreeNode root, int target, List<TreeNode> list) {
        if(root == null || target == root.val) {
            list.add(root);
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(root);
        if(root.left != null){
            getDirections_DFS(root.left,target,list);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            getDirections_DFS(root.right,target,list);
            list.remove(list.size()-1);
        }
    }
}
