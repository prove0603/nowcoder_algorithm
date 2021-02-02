package leetcode.深度优先;

/**
 * @Date 2021/1/29 16:30
 * @Created by ZhuangJie
 * @Description 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class Question100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null){return true;}
        boolean result = f(p, q);
        return result;
    }

    public boolean f(TreeNode a,TreeNode b){
        if (a==null || b==null){
            if (a!=b) {return false;}
            else {
                return true;
            }
        }
        if (a.val!=b.val){
            return false;
        }
        if(!f(a.left,b.left)){
            return false;
        }
        if(!f(a.right,b.right)){
            return false;
        }
        return true;
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
