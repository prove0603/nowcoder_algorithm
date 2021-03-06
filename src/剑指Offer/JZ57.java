package 剑指Offer;

import javax.swing.tree.TreeNode;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/14 16:42
 */

    /*
        题目描述
            给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
            注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */

//  https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e?f=discussion

public class JZ57 {

    public static TreeLinkNode result;

    public static boolean flag=false;

//    方法一
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null){
            return null;
        }
        TreeLinkNode target=pNode;
        while (pNode.next!=null){
            pNode=pNode.next;
        }
//        找根节点
        TreeLinkNode root=pNode;
        zhongXuFind(root,target);
        return result;
    }
    public static void zhongXuFind(TreeLinkNode node,TreeLinkNode target){
        if(node==null) return ;
        zhongXuFind(node.left,target);
        if (flag){
            result=node;
            flag=false;
        }
        if (nodeEqual(node,target)){
            flag=true;
        }
        zhongXuFind(node.right,target);
    }

    public static boolean nodeEqual(TreeLinkNode a,TreeLinkNode b){
        if(a.val==b.val) return true;
        else{
            return false;
        }
    }

//  方法二
    public static TreeLinkNode GetNext2(TreeLinkNode pNode) {
//        有右子树  则是右子树的最左子树
        if (pNode.right!=null){
            TreeLinkNode tmp=pNode.right;
            while (tmp.left!=null){
                tmp=tmp.left;
            }
            return tmp;
//            没有 右子树  则找其父节点 且该父节点为其父节点的左子树
        }else{
            while (pNode.next!=null){
                if (pNode.next.left==pNode){
                    return pNode.next;
                }
                pNode=pNode.next;
            }
            return null;
        }
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode tree1=new TreeLinkNode(8);
        TreeLinkNode tree2=new TreeLinkNode(6);
        TreeLinkNode tree3=new TreeLinkNode(10);
        TreeLinkNode tree4=new TreeLinkNode(5);
        TreeLinkNode tree5=new TreeLinkNode(7);
        TreeLinkNode tree6=new TreeLinkNode(9);
        TreeLinkNode tree7=new TreeLinkNode(11);
        tree1.next=null;tree1.left=tree2;tree1.right=tree3;
        tree2.next=tree1;tree2.left=tree4;tree2.right=tree5;
        tree3.next=tree1;tree3.left=tree6;tree3.right=tree7;
        tree4.next=tree2;tree4.left=null;tree4.right=null;
        tree5.next=tree2;tree5.left=null;tree5.right=null;
        tree6.next=tree3;tree6.left=null;tree6.right=null;
        tree7.next=tree3;tree7.left=null;tree7.right=null;
        System.out.println(GetNext(tree7).val);

    }
}