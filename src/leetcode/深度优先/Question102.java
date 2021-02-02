package leetcode.深度优先;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/1/29 18:50
 * @Created by ZhuangJie
 * @Description
 */
public class Question102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if (root==null) {return list;}
        if (root==null){
            return list;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int nextIndex=1;int counter=0;
        stack.addLast(root);
        ArrayList<Integer>  tmpList = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode tmp=stack.pollFirst();
            tmpList.add(tmp.val);
            counter++;
            if (tmp.left!=null){stack.addLast(tmp.left);}
            if (tmp.right!=null){stack.addLast(tmp.right);}
            if (counter==nextIndex){
                nextIndex=stack.size();
                counter=0;
                list.add(tmpList);
                tmpList=new ArrayList<>();
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
