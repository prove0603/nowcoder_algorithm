package leetcode.栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/12/12 22:42
 * @Created by ZhuangJie
 * @Description 二叉树的锯齿形层次遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Question73 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> shunxuStack = new ArrayDeque<>();
        ArrayDeque<TreeNode> nixuStack = new ArrayDeque<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (root==null) return lists;
        ArrayList tmpList=null;
        shunxuStack.addLast(root);
        while (!shunxuStack.isEmpty() || !nixuStack.isEmpty()){
            tmpList=new ArrayList<Integer>();
            while (!shunxuStack.isEmpty()){
                TreeNode tmp=shunxuStack.pollLast();
                tmpList.add(tmp.val);
                if (tmp.left!=null) nixuStack.addLast(tmp.left);
                if (tmp.right!=null) nixuStack.addLast(tmp.right);
            }
            if (tmpList.size()!=0) lists.add(tmpList);
            tmpList=new ArrayList<Integer>();
            while (!nixuStack.isEmpty()){
                TreeNode tmp = nixuStack.pollLast();
                tmpList.add(tmp.val);
                if (tmp.right!=null) shunxuStack.addLast(tmp.right);
                if (tmp.left!=null) shunxuStack.addLast(tmp.left);
            }
            if (tmpList.size()!=0) lists.add(tmpList);
        }
        return lists;
    }

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层次遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
