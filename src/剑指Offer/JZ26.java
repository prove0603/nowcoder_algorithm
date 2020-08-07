package 剑指Offer;

import java.util.ArrayList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/7 9:11
 */

/*
    题目描述
        输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
        https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5?f=discussion

        太困了 未研究他人算法

 */


public class JZ26 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null) return null;
        ArrayList<TreeNode> arrayList=new ArrayList<>();
        f(pRootOfTree,arrayList);
        for (int i = 0; i <arrayList.size()-1 ; i++) {
            arrayList.get(i).right=arrayList.get(i+1);
            arrayList.get(i+1).left=arrayList.get(i);
        }
        arrayList.get(0).left=null;
        arrayList.get(arrayList.size()-1).right=null;
        return arrayList.get(0);
    }

    public ArrayList<TreeNode> f(TreeNode root ,ArrayList<TreeNode> list){
        if (root==null) return null;
        f(root.left,list);
        list.add(root);
        f(root.right,list);
        return list;
    }
}
