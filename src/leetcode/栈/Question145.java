package leetcode.栈;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/12/12 22:18
 * @Created by ZhuangJie
 * @Description
 * 二叉树的后序遍历
 */
public class Question145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
//        用于判断右子树是否已经遍历过了
        TreeNode rightNode=null;
        while (root!=null || !stack.isEmpty()){
            if (root!=null){
                stack.addLast(root);
                root=root.left;
            }else {
                TreeNode tmp=stack.peekLast();
//                说明已经遍历过了
                if (tmp.right==null ||tmp.right==rightNode){
                    stack.pollLast();
                    arrayList.add(tmp.val);
                    rightNode=tmp;
                    root=null;
                }else {
                    root=root.right;
                }
            }
        }
        return arrayList;
    }


    /*
    递归
    static ArrayList<Integer> arrayList;
    public List<Integer> postorderTraversal(TreeNode root) {
        arrayList=new ArrayList();
        f(root);
        return arrayList;
    }

    public void f(TreeNode root){
        if(root == null){
            return;
        }else{
            f(root.left);
            f(root.right);
            arrayList.add(root.val);
        }
    }
     */
}
