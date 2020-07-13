package 剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/13 16:05
 */
public class JZ38 {
    /*
    题目描述
        输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */

//https://www.nowcoder.com/questionTerminal/435fb86331474282a3499955f0a41e8b?answerType=1&f=discussion

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    递归
    public int TreeDepth(TreeNode root) {
        if (root ==null) return 0;
        int leftVal=TreeDepth(root.left);
        int rightVal=TreeDepth(root.right);
        return (leftVal>rightVal?leftVal:rightVal)+1;
    }

//    使用队列  横向遍历
//    public int TreeDepth(TreeNode root){
//        if(root ==null) return 0;
//        Queue<TreeNode> queue=new LinkedList<>();
//        int count=0,deep=0,nextCount=1;
//        queue.add(root);
//        while (!queue.isEmpty()){
//            TreeNode p=queue.poll();
//            count++;
//            if (p.left!=null) queue.add(p.left);
//            if (p.right!=null) queue.add(p.right);
//            if (count==nextCount){
//                deep++;
//                nextCount=queue.size();
//                count=0;
//            }
//        }
//        return deep;
//    }
}
