package leetcode.深度优先;

import java.util.ArrayDeque;

/**
 * @Date 2021/2/2 0:22
 * @Created by ZhuangJie
 * @Description
 */
public class Question116 {

    public Node connect(Node root) {
        if (root==null){
            return root;
        }
        int nextIndex=1,index=0;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()){
            Node tmp = stack.pollFirst();
            index++;
            if (tmp.left!=null){stack.addLast(tmp.left);}
            if (tmp.right!=null){stack.addLast(tmp.right);}
            if (index!=nextIndex){
                tmp.next=stack.peekFirst();
            }
            if (index==nextIndex){
                index=0;
                nextIndex=stack.size();
            }
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
