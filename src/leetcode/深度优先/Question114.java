package leetcode.深度优先;

import java.util.ArrayList;

/**
 * @Date 2021/2/1 2:14
 * @Created by ZhuangJie
 * @Description
 */
public class Question114 {
    public void flatten(TreeNode root) {
        if (root==null) {return;}
        ArrayList<TreeNode> list = f(root, new ArrayList<>());
        for (int i = 0; i <list.size()-1 ; i++) {
            TreeNode cur=list.get(i);
            TreeNode next=list.get(i+1);
            cur.left=null;
            cur.right=next;
        }
    }
    public ArrayList<TreeNode> f(TreeNode node,ArrayList<TreeNode> list){
        if (node==null) {return list;}
        list.add(node);
        f(node.left,list);
        f(node.right,list);
        return list;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
