package leetcode.深度优先;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/2/1 1:47
 * @Created by ZhuangJie
 * @Description
 */
public class Question113 {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) {return result;}
        f(root,new ArrayList<Integer>(),0,targetSum);
        return result;
    }
    public void f(TreeNode node,ArrayList<Integer> list,int sum,int target){
        if (node==null){return;}
        sum+= node.val;
        list.add(node.val);
        if (sum==target && node.left==null && node.right==null){
            ArrayList<Integer> clone=(ArrayList) list.clone();
            result.add(clone);
            list.remove(list.size()-1);
            return;
        }
        f(node.left,list,sum,target);
        f(node.right,list,sum,target);
        list.remove(list.size()-1);
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
