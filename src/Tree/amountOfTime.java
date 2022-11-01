package Tree;

import java.util.*;

/**
 * @ClassName:amountOfTime
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * @Date: 01/11/2022 11:28
 * @Version: v1.0
 */
public class amountOfTime {


    public static void main(String[] args) {
        amountOfTime test = new amountOfTime();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left  = new TreeNode(5);
        treeNode.right  = new TreeNode(3);
        treeNode.left.right  = new TreeNode(4);
        treeNode.left.right.left  = new TreeNode(9);
        treeNode.left.right.right  = new TreeNode(2);
        treeNode.right.left  = new TreeNode(10);
        treeNode.right.right  = new TreeNode(6);
        test.amountOfTime(treeNode,3);
    }
    // similar to  https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    Map<Integer,List<Integer>> graph = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        if(root==null) return 0;
        createGraph(root,null );
        int deep = 0 ;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int curr = queue.poll();
                if(visited.contains(curr)) continue;
                visited.add(curr);
                for(int key : graph.get(curr)){
                    if(visited.contains(key)) continue;
                    queue.add(key);
                }
            }
            deep++;
        }
        return deep-1;
    }

    private void createGraph(TreeNode root, TreeNode father) {
        if(root == null) return;
        graph.putIfAbsent(root.val, new ArrayList<>());
        if(father!=null) graph.get(root.val).add(father.val);
        if(root.right!=null)graph.get(root.val).add(root.right.val);
        if(root.left!=null)graph.get(root.val).add(root.left.val);
        createGraph(root.left,root);
        createGraph(root.right,root);
    }


}
