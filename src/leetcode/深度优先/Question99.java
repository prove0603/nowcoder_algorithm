package leetcode.深度优先;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @Date 2021/1/28 18:21
 * @Created by ZhuangJie
 * @Description 恢复二叉搜索树
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class Question99 {
    ArrayList<Integer> list=new ArrayList<>();
    ArrayList<Integer> error=new ArrayList<>();
    public void recoverTree(TreeNode root) {
        if(root==null) {return ;}
        middleSearch(root);
        ArrayList<Integer> newList = new ArrayList<>(list);
        Collections.sort(list);
        for (int i = 0; i <list.size() ; i++) {
            if (newList.get(i)!=list.get(i)){
                error.add(newList.get(i));
                error.add(list.get(i));
                break;
            }
        }
        fix(root);
    }
    public void middleSearch(TreeNode treeNode){
        if (treeNode==null){return ;}
        middleSearch(treeNode.left);
        list.add(treeNode.val);
        middleSearch(treeNode.right);
    }
    public void fix(TreeNode treeNode){
        if (treeNode==null){return ;}
        fix(treeNode.left);
        if (treeNode.val==error.get(0)){
            treeNode.val=error.get(1);
        }
        else if (treeNode.val==error.get(1)){
            treeNode.val=error.get(0);
        }
        fix(treeNode.right);
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
