package 剑指Offer;

import java.util.LinkedList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/7 10:01
 */

/*
    题目描述
        请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

        https://www.nowcoder.com/questionTerminal/ff05d44dfdb04e1d83bdbdab320efbcb?f=discussion
            未研究他人写法
 */
public class JZ58 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null) return true;
//        TreeNode copyRoot=mirrorTree(pRoot);  不能这样写   是因为proot虽然会在方法里拷贝副本  但是因为方法改变的是其指向地址的值  所以proot也会跟着改变
        TreeNode copyRoot=new TreeNode(pRoot.val);
        copyTree(pRoot,copyRoot);
        mirrorTree(copyRoot);
        return treeEquals(pRoot,copyRoot);
    }

    TreeNode mirrorTree(TreeNode treeNode){
        if (treeNode==null) return null;
        TreeNode tmp=treeNode.left;
        treeNode.left=treeNode.right;
        treeNode.right=tmp;
        mirrorTree(treeNode.left);
        mirrorTree(treeNode.right);
        return treeNode;
    }

    TreeNode copyTree(TreeNode treeNode,TreeNode copy){
        if (treeNode==null) return null;
        if (treeNode.left!=null) {
            copy.left=new TreeNode(treeNode.left.val);
        }
        if (treeNode.right!=null) {
            copy.right=new TreeNode(treeNode.right.val);
        }
        copyTree(treeNode.left,copy.left);
        copyTree(treeNode.right,copy.right);
        return copy;
    }
    boolean treeEquals(TreeNode treeNode1,TreeNode treeNode2){
        if (treeNode1==null && treeNode2!=null) return false;
        if (treeNode2==null && treeNode1!=null) return false;
        if (treeNode2==null && treeNode1==null) return true;
        if (treeNode1.val!=treeNode2.val) return false;
        return treeEquals(treeNode1.left,treeNode2.left) && treeEquals(treeNode1.right,treeNode2.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        JZ58 jz58 = new JZ58();
        System.out.println(jz58.isSymmetrical(a));
    }
}
