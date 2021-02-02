package leetcode.深度优先;

/**
 * @Date 2021/1/31 2:45
 * @Created by ZhuangJie
 * @Description
 * 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Question110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) {return true;}
        if (Math.abs(depth(root.left)-depth(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if (root==null) {return 0;}
        int depth=Math.max(depth(root.left),depth(root.right))+1;
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
