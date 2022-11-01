package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName:isEvenOddTree
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/even-odd-tree/
 * @Date: 01/11/2022 19:16
 * @Version: v1.0
 */
public class isEvenOddTree {

    public static void main(String[] args) {
        isEvenOddTree test = new isEvenOddTree();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left  = new TreeNode(4);
        treeNode.right  = new TreeNode(2);
        treeNode.left.right  = new TreeNode(1);
        treeNode.left.left  = new TreeNode(3);
        treeNode.right.right  = new TreeNode(1);
        test.isEvenOddTree(treeNode);

    }

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int deep = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = deep % 2 == 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
            for(int i =0;i<size;i++){
                TreeNode cur = queue.poll();
                int val = cur.val;
                if((deep % 2 == 0 && val %2 !=0) || (deep % 2 != 0 && val %2 ==0) ) {
                    return false;
                }
                if(deep % 2 == 0){
                    if(max <= val) return false;
                    else max = val;
                }else {
                    if(max >= val) return false;
                    else max = val;
                }

                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);

            }
            deep++;
        }
        return true;
    }



}
