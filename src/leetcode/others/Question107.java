package leetcode.others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/2/13 21:09
 * @Created by ZhuangJie
 * @Description
 */
public class Question107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        ArrayDeque<ArrayList<Integer>> tmpResult = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int nextIndex=1,counter=0;
        stack.addLast(root);
        while (stack.isEmpty()){
            ArrayList<Integer> tmpList = new ArrayList<>();
            TreeNode tmp=stack.pollFirst();
            tmpList.add(tmp.val);
            counter++;
            if (tmp.left!=null) {stack.addLast(tmp.left);}
            if (tmp.right!=null) {stack.addLast(tmp.right);}
            if (counter==nextIndex){
                tmpResult.addFirst(tmpList);
                tmpList=new ArrayList<>();
                counter=0;
                nextIndex=stack.size();
            }
        }
        result=new ArrayList<>(tmpResult);
        return result;
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
