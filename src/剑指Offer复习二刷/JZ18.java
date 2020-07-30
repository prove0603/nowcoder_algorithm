package 剑指Offer复习二刷;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/30 15:15
 */

    /*
        题目描述
            操作给定的二叉树，将其变换为源二叉树的镜像。
            输入描述:

            二叉树的镜像定义：源二叉树
                        8
                       /  \
                      6   10
                     / \  / \
                    5  7 9 11
                    镜像二叉树
                        8
                       /  \
                      10   6
                     / \  / \
                    11 9 7  5
     */

public class JZ18 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    递归法
//    public void Mirror(TreeNode root)  {
//        if (root==null) return;
//        TreeNode tmp=root.left;
//        root.left=root.right;
//        root.right=tmp;
//        Mirror(root.left);
//        Mirror(root.right);
//    }

//    非递归法
    public void Mirror(TreeNode root)  {
        if (root==null) return;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int index=0,nextCounting=1;
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            TreeNode tmp=node.left;
            node.left=node.right;
            node.right=tmp;
            index++;
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
            if (index==nextCounting){
                index=0;
                nextCounting=queue.size();
            }
        }
    }

    public static void main(String[] args) {
        JZ18 jz18=new JZ18();
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        a.left=b;a.right=c;
        jz18.Mirror(a);
        System.out.println(a.val);
        System.out.println(a.left.val);
        System.out.println(a.right.val);
    }
}
