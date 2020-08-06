package 剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/6 10:59
 */

/*
        题目描述
            输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

 */
public class JZ17 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 ==null || root2==null){
            return false;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root1);
        int index=1,nextIndex=1;
        while (!queue.isEmpty()){
            TreeNode tmp=queue.poll();
//            有节点的值 相同  进入判断
            if (tmp.val==root2.val){
                if (f(tmp,root2)){
                    return true;
                }
            }
            if (tmp.left!=null) {
                queue.add(tmp.left);
            }
            if (tmp.right!=null) {
                queue.add(tmp.right);
            }
        }
        return false;
    }

//    不是最简
    public boolean f(TreeNode a,TreeNode b){
        if (a.left==null && b.left!=null) return false;
        if (a.right==null && b.right!=null) return false;
        if (b.left==null && b.right==null) return true;
        if (a.left!=null &&b.left!=null){
            if (a.left.val!=b.left.val) return false;
            else if (f(a.left,b.left)==false) return false;
        }
        if (a.right!=null &&b.right!=null){
            if (a.right.val!=b.right.val) return false;
            else if (f(a.right,b.right)==false) return false;
        }
        return true;
    }

    //用这个思路会更简洁
    //www.nowcoder.com/questionTerminal/6e196c44c7004d15b1610b9afca8bd88?f=discussion
    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (node2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (node1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (node1.val != node2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
    }
    public static void main(String[] args) {
        String a=new String("1234");
        System.out.println(a.contains("23"));
    }
}
