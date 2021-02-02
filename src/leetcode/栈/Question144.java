package leetcode.栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/12/12 21:54
 * @Created by ZhuangJie
 * @Description 二叉树的先序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
 */
public class Question144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (root !=null || !stack.isEmpty()){
            if (root !=null){
                arrayList.add(root.val);
                stack.addLast(root);
                root=root.left;
            }else {
                TreeNode tmp=stack.pollLast();
                root=tmp.right;
            }
        }
        return arrayList;
    }
}


class TreeNode {
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


