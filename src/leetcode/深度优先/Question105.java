package leetcode.深度优先;

/**
 * @Date 2021/1/30 2:02
 * @Created by ZhuangJie
 * @Description 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 */
public class Question105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len= preorder.length;
        if (len==0){return  null;}
        if (len==1){
            TreeNode node = new TreeNode(preorder[0]);
            return node;
        }
        TreeNode result=f(preorder,inorder,0, preorder.length-1, 0, inorder.length-1);
        return result;
    }

    public TreeNode f(int[] preorder, int[] inorder,int preStart,int preEnd,int inStart,int inEnd) {
        if (preStart>preEnd ) {return null;}
        TreeNode node = new TreeNode(preorder[preStart]);
        int tmp=0;
        for (int i = inStart; i <=inEnd ; i++) {
            if (inorder[i]==preorder[preStart]){
                tmp=i;
                break;
            }
        }
        //重要！！！
        int preLeftNum=tmp-inStart;
        node.left=f(preorder,inorder,preStart+1,preStart+preLeftNum,inStart,tmp-1);
        node.right=f(preorder,inorder,preStart+preLeftNum+1,preEnd,tmp+1,inEnd);
        return node;
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
