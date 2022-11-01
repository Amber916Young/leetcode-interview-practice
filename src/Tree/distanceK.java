package Tree;

import java.util.*;

/**
 * @ClassName:distanceK
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * @Date: 31/10/2022 21:46
 * @Version: v1.0
 */
public class distanceK  {

    public static void main(String[] args) {
        distanceK test = new distanceK();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left  = new TreeNode(4);
        treeNode.right  = new TreeNode(5);
        treeNode.left.right  = new TreeNode(1);
        treeNode.left.left  = new TreeNode(1);
        treeNode.right.right  = new TreeNode(5);
//        test.distanceK(treeNode,);

    }
    Map<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }


    Map<Integer,List<Integer>> map = new HashMap<>(); //map the nodes and its neightbor
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        if(root==null) return new ArrayList<Integer>();
        Graphdfs(root,null); //create graph
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(target.val);
        visited.add(target.val);
        int step = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                if(step == k){
                    return new ArrayList<Integer>(q);
                }
                int cur = q.poll();
                if(map.get(cur)!=null){
                    for(int nei: map.get(cur)){
                        if(visited.contains(nei)) continue;
                        q.add(nei);
                        visited.add(nei);
                    }
                }
            }
            step++;
        }
        return new ArrayList<>();
    }

    //build Graph
    public void Graphdfs(TreeNode root, TreeNode father){
        if(root == null) return;
        map.putIfAbsent(root.val, new ArrayList<>());
        if(father!=null) map.get(root.val).add(father.val);
        if(root.right!=null)map.get(root.val).add(root.right.val);
        if(root.left!=null)map.get(root.val).add(root.left.val);
        Graphdfs(root.left,root);
        Graphdfs(root.right,root);
    }

}
