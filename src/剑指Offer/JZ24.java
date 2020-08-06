package 剑指Offer;

import java.util.ArrayList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/6 15:11
 */

/*
    题目描述
        输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
        路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class JZ24 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static ArrayList<ArrayList<Integer>> result;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        result=new ArrayList<>();
        if (root==null || target<0) return result;
        f(root,target,new ArrayList<Integer>());
        return result;
    }
//  理解tmp.remove的 多次出现 特别是在两个if语句里的出现
    public void f(TreeNode treeNode,int target,ArrayList<Integer> tmp){
        if (treeNode==null) return ;
        target-=treeNode.val;
        tmp.add(treeNode.val);
        int index=tmp.size();
        if (target<0){
            tmp.remove(index-1);
            return;
        }
        if (target==0 && treeNode.left==null && treeNode.right==null){
            ArrayList<Integer> list=(ArrayList<Integer>) tmp.clone();
            result.add(list);
            tmp.remove(tmp.size()-1);
            return;
        }
        f(treeNode.left,target,tmp);
        f(treeNode.right,target,tmp);
        tmp.remove(tmp.size()-1);
    }

    /*
            更简洁
    链接：https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca?f=discussion
    来源：牛客网

    public class Solution {
        private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        private ArrayList<Integer> list = new ArrayList<Integer>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            if(root == null) return listAll;
            list.add(root.val);
            target -= root.val;
            if(target == 0 && root.left == null && root.right == null)
                listAll.add(new ArrayList<Integer>(list));
            FindPath(root.left, target);
            FindPath(root.right, target);
            list.remove(list.size()-1);
            return listAll;
        }
    }
     */
    public static void main(String[] args) {
        TreeNode a=new TreeNode(10);
        TreeNode b=new TreeNode(5);
        TreeNode c=new TreeNode(12);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(7);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        ArrayList<ArrayList<Integer>> lists= new JZ24().FindPath(a,22);
        result.get(0).get(0);
        System.out.println(123);
    }
}
