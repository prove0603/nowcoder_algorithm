package leetcode.深度优先;

/**
 * @Date 2021/2/1 1:23
 * @Created by ZhuangJie
 * @Description
 */
public class Question112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) {return false;}
        return f(root,0,targetSum);
    }
    public boolean f(TreeNode node,int sum,int targetSum){
        if(node ==null) {return false;}
        sum+= node.val;
        if (sum==targetSum) {return true;}
        if (sum>targetSum){
            sum-= node.val;
            return false;
        }
        return f(node.left,sum,targetSum) || f(node.right,sum,targetSum);
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
