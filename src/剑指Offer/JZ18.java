package 剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/14 9:37
 */
public class JZ18 {
//      操作给定的二叉树，将其变换为源二叉树的镜像。
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    递归
    public void Mirror(TreeNode root)  {
        if (root==null) return;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
/*  非递归
    public void Mirror(TreeNode root)  {
        if (root==null) return ;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if (node.left !=null){
                queue.add(node.left);
            }
            if (node.right !=null){
                queue.add(node.right);
            }
            TreeNode tmp=node.left;
            node.left=node.right;
            node.right=tmp;
        }
    }

 */
}
