package leetcode.动态规划;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/1/7 1:15
 * @Created by ZhuangJie
 * @Description 不同的二叉搜索树 II
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 题解：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
 */
public class Question95 {
    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> res = f(1, n);
        return res;
    }

    public List<TreeNode> f(int start,int end){
        ArrayList<TreeNode> allTrees = new ArrayList<>();
        if (start>end){
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> leftTrees = f(start,i-1);
            List<TreeNode> rightTrees = f(i+1,end);
            for (TreeNode left:leftTrees) {
                for (TreeNode right:rightTrees) {
                    TreeNode current = new TreeNode(i);
                    current.left=left;
                    current.right=right;
                    allTrees.add(current);
                }
            }
        }
        return allTrees;
    }
    class TreeNode {
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
