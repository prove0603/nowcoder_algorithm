package leetcode.深度优先;

import java.util.ArrayList;

/**
 * @Date 2021/2/2 2:14
 * @Created by ZhuangJie
 * @Description
 */
public class Question129 {

    ArrayList<StringBuilder> result=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root==null) {return 0;}
        f(root,new StringBuilder());
        int counter=0;
        for (StringBuilder builder:result) {
            int tmp=Integer.parseInt(builder.toString());
            counter+=tmp;
        }
        return counter;
    }

    public void f(TreeNode node,StringBuilder builder){
        if (node==null) {return;}
        builder.append(node.val);
        if (node.left==null && node.right==null){
            StringBuilder tmp = new StringBuilder(builder);
            result.add(tmp);
            builder.deleteCharAt(tmp.length()-1);
            return;
        }
        f(node.left,builder);
        f(node.right,builder);
        builder.deleteCharAt(builder.length()-1);
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
