package leetcode.栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/12/12 22:07
 * @Created by ZhuangJie
 * @Description
 * 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Question94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (root!=null || !stack.isEmpty()){
            if (root!=null){
                stack.addLast(root);
                root=root.left;
            }else {
                TreeNode tmp=stack.pollLast();
                arrayList.add(tmp.val);
                root=root.right;
            }
        }
        return arrayList;
    }
}
