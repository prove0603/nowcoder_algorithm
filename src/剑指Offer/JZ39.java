package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/7 9:40
 */

/*
    题目描述
        输入一棵二叉树，判断该二叉树是否是平衡二叉树。

        在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树

        https://www.nowcoder.com/questionTerminal/8b3b95850edb4115918ecebdf1b4d222?f=discussion

        太困了  未研究他人写法
 */
public class JZ39 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null) return true;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        if (Math.abs(left-right)>1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int getHeight(TreeNode treeNode){
        if (treeNode == null) return 0;
        int left=getHeight(treeNode.left);
        int right=getHeight(treeNode.right);
        return Integer.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(5);
        TreeNode f=new TreeNode(6);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        e.left=f;
        JZ39 jz39=new JZ39();
        System.out.println(jz39.IsBalanced_Solution(a));
    }
}
