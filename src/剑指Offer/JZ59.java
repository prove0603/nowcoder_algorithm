package 剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/7 11:40
 */

    /*
        题目描述
            请实现一个函数按照之字形打印二叉树，
            即第一行按照从左到右的顺序打印，
            第二层按照从右至左的顺序打印，
            第三行按照从左到右的顺序打印，其他行以此类推。

            !!!     区分LinkedList的 add(插在尾部) 与 push(插在头部)
            !!!     使用两个栈的话  就可以避免reverse
    */
public class JZ59 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

//    使用两个栈
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if (pRoot==null) return result;
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(pRoot);
        ArrayList<Integer> list;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            list=new ArrayList<>();
            while (!stack1.isEmpty()){
                TreeNode tmpNode=stack1.pop();
//                stack2 放逆序的
                if (tmpNode.left!=null){
                    stack2.push(tmpNode.left);
                }
                if (tmpNode.right!=null){
                    stack2.push(tmpNode.right);
                }
                list.add(tmpNode.val);
                if (stack1.isEmpty()) result.add(list);
            }
            list=new ArrayList<>();
            while (!stack2.isEmpty()){
                TreeNode tmpNode=stack2.pop();
//                stack1 放顺序的
                if (tmpNode.right!=null){
                    stack1.push(tmpNode.right);
                }
                if (tmpNode.left!=null){
                    stack1.push(tmpNode.left);
                }
                list.add(tmpNode.val);
                if (stack2.isEmpty()) result.add(list);
            }
        }
        return result;
    }


//  使用  reverse
//    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
//        if (pRoot==null) return result;
//        LinkedList<TreeNode> linkedList=new LinkedList<>();
//        int index=0,nextIndex=1,order=1; //order=1 代表顺序  order=-1 代表逆序
//        linkedList.add(pRoot);
//        ArrayList<Integer> list=new ArrayList<>();
//        while (!linkedList.isEmpty()){
//            TreeNode tmp=linkedList.poll();
//            index++;
//            list.add(tmp.val);
//            if (tmp.left!=null) linkedList.add(tmp.left);
//            if (tmp.right!=null) linkedList.add(tmp.right);
//            if (index==nextIndex){
//                nextIndex=linkedList.size();
//                index=0;
//                if (order==-1){
//                    Collections.reverse(list);
//                }
//                result.add((ArrayList<Integer>) list.clone());
//                list.clear();
//                order=-order;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
//        TreeNode a = new TreeNode(8);
//        TreeNode b = new TreeNode(6);
//        TreeNode c = new TreeNode(10);
//        TreeNode d = new TreeNode(5);
//        TreeNode e = new TreeNode(7);
//        TreeNode f = new TreeNode(9);
//        TreeNode g = new TreeNode(11);
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;
//        JZ59 jz59=new JZ59();
//        jz59.Print(a);
//        LinkedList<Integer> linkedList=new LinkedList<>();
//
//        linkedList.push(1);
//        linkedList.push(2);
//        linkedList.push(3);
//        System.out.println(linkedList.poll());
//        System.out.println(linkedList.poll());
//        System.out.println(linkedList.poll());
    }
}
