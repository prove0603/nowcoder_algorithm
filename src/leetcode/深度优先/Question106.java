package leetcode.深度优先;

/**
 * @Date 2021/1/31 0:23
 * @Created by ZhuangJie
 * @Description 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Question106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 1) {
            return new TreeNode(inorder[0]);
        }
        return f(inorder, 0, len - 1, postorder, 0, len - 1);
    }

    public TreeNode f(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(postorder[poEnd]);
        int tmp = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[poEnd]) {
                tmp = i;
                break;
            }
        }
        int inLeftNum = tmp - inStart;
        treeNode.left = f(inorder, inStart, tmp - 1, postorder, poStart, poStart + inLeftNum - 1);
        treeNode.right = f(inorder, tmp + 1, inEnd, postorder, poStart + inLeftNum, poEnd - 1);
        return treeNode;
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
