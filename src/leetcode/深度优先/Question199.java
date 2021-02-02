package leetcode.深度优先;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/2/2 2:35
 * @Created by ZhuangJie
 * @Description
 */
public class Question199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null){
            return list;
        }
        int nextIndex=1,index=0;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pollFirst();
            index++;
            if (tmp.left!=null){stack.addLast(tmp.left);}
            if (tmp.right!=null){stack.addLast(tmp.right);}
            if (index==nextIndex){
                list.add(tmp.val);
            }
            if (index==nextIndex){
                index=0;
                nextIndex=stack.size();
            }
        }
        return list;
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
