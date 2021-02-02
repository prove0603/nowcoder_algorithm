package leetcode.深度优先;

import java.util.ArrayList;

/**
 * @Date 2021/1/28 0:50
 * @Created by ZhuangJie
 * @Description 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Question98 {
    Integer pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isValidBST(root.left)) { 
            return false;
        }
        //为了防止第一个数就是Integer.MINVALUE
        if(pre != null && root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
    //不够简洁
//    ArrayList<Integer> list=new ArrayList<>();
//    public boolean isValidBST(TreeNode root) {
//        if(root==null) {return true;}
//        zhongxu(root);
//        for (int i = 0; i <list.size()-1 ; i++) {
//            if (list.get(i)<list.get(i+1)){
//                continue;
//            }else {
//                return false;
//            }
//        }
//        return true;
//    }
//    public void zhongxu(TreeNode treeNode){
//        if (treeNode==null){return;}
//        zhongxu(treeNode.left);
//        list.add(treeNode.val);
//        zhongxu(treeNode.right);
//    }
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
