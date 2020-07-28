package 剑指Offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 15:01
 */

/*
    题目描述
        从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class JZ22 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (root==null) return arrayList;
        Queue<TreeNode> queue=new LinkedList<>();
        int counter=0,nextCounting=1;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            counter++;
            arrayList.add(node.val);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
            if (counter==nextCounting){
                counter=0;
                nextCounting=queue.size();
            }
        }
        return arrayList;
    }
}
