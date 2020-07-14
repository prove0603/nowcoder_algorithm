package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/14 15:36
 */

/*
    题目描述
        从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

 */
public class JZ60 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> totalList=new ArrayList<>();
        if (pRoot==null) return totalList;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(pRoot);
        int count=0,nextCount=1;
        boolean flag=false;
        ArrayList<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if (flag){
                list=new ArrayList<>();
                flag=false;
            }
            list.add(node.val);
            count++;
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
            if (count==nextCount){
                totalList.add(list);
                count=0;
                nextCount=queue.size();
                flag=true;
            }
        }
        return totalList;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(8);
        node.left=new TreeNode(6);
        node.right=new TreeNode(10);
        node.left.left=new TreeNode(5);
        node.left.right=new TreeNode(7);
        node.right.left=new TreeNode(9);
        node.right.right=new TreeNode(11);
        Print(node);
    }


    //用递归做的
    public class Solution {
        ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            depth(pRoot, 1, list);
            return list;
        }

        private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
            if(root == null) return;
            if(depth > list.size())
                list.add(new ArrayList<Integer>());
            list.get(depth -1).add(root.val);

            depth(root.left, depth + 1, list);
            depth(root.right, depth + 1, list);
        }
    }
}
