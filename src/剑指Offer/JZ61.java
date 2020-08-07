package 剑指Offer;

import java.util.LinkedList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/7 15:31
 */

    /*
        题目描述
            请实现两个函数，分别用来序列化和反序列化二叉树

            二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
            从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
            序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

            二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

            例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树

    */
public class JZ61 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

//  先序遍历
    String Serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) return "#";
        stringBuilder=xianXu(root,stringBuilder);
        return stringBuilder.toString();
    }
    StringBuilder xianXu(TreeNode root,StringBuilder stringBuilder){
        if (root==null) {
            stringBuilder.append("#!");
            return null;
        }
        stringBuilder.append(root.val);
        stringBuilder.append('!');
        xianXu(root.left,stringBuilder);
        xianXu(root.right,stringBuilder);
        return stringBuilder;
    }

    TreeNode Deserialize(String str) {
        if (str.equals("#")) return null;

        return f(str);
    }

    public static int start=0;

    TreeNode f(String str){
        int index=str.indexOf("!",start);
        String val=str.substring(start,index);
        start=index+1;
        if (val.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(val));
        node.left=f(str);
        node.right=f(str);
        return node;
    }

//    层次遍历  最后一层会多出#！ 但是在反序列化时没有影响  思考为什么没有影响
//    String Serialize(TreeNode root) {
//        StringBuilder stringBuilder = new StringBuilder();
//        if (root == null) return "#";
//        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        linkedList.add(root);
//        while (!linkedList.isEmpty()) {
//            TreeNode tmpNode = linkedList.poll();
//            if (tmpNode.val != -1) {
//                stringBuilder.append(tmpNode.val);
//                stringBuilder.append('!');
//            } else {
//                stringBuilder.append('#');
//                stringBuilder.append('!');
//                continue;
//            }
//
//            if (tmpNode.left == null) {
//                linkedList.add(new TreeNode(-1));
//            } else {
//                linkedList.add(tmpNode.left);
//            }
//            if (tmpNode.right == null) {
//                linkedList.add(new TreeNode(-1));
//            } else {
//                linkedList.add(tmpNode.right);
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//    //    1!2!3!4!#!#!#!#!#!
//    TreeNode Deserialize(String str) {
//        if (str.equals("#")) return null;
//        int tmp = str.indexOf('!');
//        int firstVal = Integer.parseInt(str.substring(0, tmp));
//        TreeNode root = new TreeNode(firstVal);
//        TreeNode current=root;
//        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        linkedList.add(current);
//        while (!linkedList.isEmpty()){
//            TreeNode tmpNode=linkedList.poll();
//            int leftIndex=str.indexOf('!',tmp+1);
//            String leftVal=(str.substring(tmp+1, leftIndex));
//            tmp=leftIndex;
//            if (leftVal.equals("#")){
//                tmpNode.left=null;
//            }else {
//                tmpNode.left=new TreeNode(Integer.parseInt(leftVal));
//                linkedList.add(tmpNode.left);
//            }
//
//            int rightIndex=str.indexOf('!',tmp+1);
//            String rightVal=(str.substring(tmp+1, rightIndex));
//            tmp=rightIndex;
//            if (rightVal.equals("#")){
//                tmpNode.right=null;
//            }else {
//                tmpNode.right=new TreeNode(Integer.parseInt(rightVal));
//                linkedList.add(tmpNode.right);
//            }
//        }
//        return root;
//    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
//        System.out.println(new JZ61().Serialize(a));
//        String str="a!b!c!";
//        int index=str.indexOf('!',2);
//        System.out.println(index);
        TreeNode abc=new JZ61().Deserialize("1!2!4!#!#!#!3!#!#!");
        System.out.println(abc.val);
    }

}
