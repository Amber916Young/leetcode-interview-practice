package Tree;

import java.util.*;

/**
 * @ClassName:kthSmallest
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @Date: 20/10/2022 16:09
 * @Version: v1.0
 */
public class kthSmallest {

    //TODO typically, the keyword "Kth smallest/greatest"
    // I will use PriorityQueue to figure out this kind of problem

    int Capacity = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root.right==null && root.left==null) return root.val;
        /*
         * how to define the queue as ASC or DESC
         * https://blog.csdn.net/Sherlock_Obama/article/details/113789795
         * */
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        Capacity = k;
        helper_kthSmallest(root,queue);
        return queue.peek();
    }

    private void helper_kthSmallest(TreeNode root,    PriorityQueue<Integer> queue ) {
        if (root==null) return;
        queue.offer(root.val);

        if(queue.size() > Capacity){
            queue.poll();
        }
        helper_kthSmallest(root.right,queue);
        helper_kthSmallest(root.left,queue);
    }

    // method
    public int kthSmallest2(TreeNode root, int k) {
        if (root.right==null && root.left==null) return root.val;
        ArrayList<Integer> list = new ArrayList<>();
        helper_kthSmallest(root,list);
        Collections.sort(list);
        return list.get(k-1);
    }

    private void helper_kthSmallest(TreeNode root, List<Integer> list) {
        if (root==null) return;
        helper_kthSmallest(root.right,list);
        list.add(root.val);
        helper_kthSmallest(root.left,list);
    }

}
