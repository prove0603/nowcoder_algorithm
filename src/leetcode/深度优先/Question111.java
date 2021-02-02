package leetcode.深度优先;

import java.util.ArrayDeque;

/**
 * @Date 2021/2/1 1:05
 * @Created by ZhuangJie
 * @Description
 */
public class Question111 {

    public int minDepth(TreeNode root) {
        if (root==null) {return 0;}
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int nextIndex=1,index=0,depth=1;
        stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode tmp=stack.pollFirst();
            index++;
            if (tmp.left==null && tmp.right==null){
                break;
            }
            if (tmp.left!=null) {stack.addLast(tmp.left);}
            if (tmp.right!=null) {stack.addLast(tmp.right);}
            if (index==nextIndex){
                index=0;
                nextIndex=stack.size();
                depth++;
            }
        }
        return depth;
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
