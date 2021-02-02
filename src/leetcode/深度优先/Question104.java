package leetcode.深度优先;

import java.util.ArrayDeque;

/**
 * @Date 2021/1/29 17:13
 * @Created by ZhuangJie
 * @Description 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Question104 {
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int nextIndex=1;int depth=0,counter=0;
        stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode tmp=stack.pollFirst();
            counter++;
            if (tmp.left!=null){stack.addLast(tmp.left);}
            if (tmp.right!=null){stack.addLast(tmp.right);}
            if (counter==nextIndex){
                nextIndex=stack.size();
                counter=0;
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
