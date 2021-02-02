package leetcode.深度优先;

/**
 * @Date 2021/1/31 2:14
 * @Created by ZhuangJie
 * @Description
 * 将有序数组转换为二叉搜索树
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Question108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        if (len==0){return null;}
        if (len==1){return new TreeNode(nums[0]);}
        return f(nums,0,len-1);
    }
    public TreeNode f(int[] nums,int start,int end){
        if (start>end){return null;}
        int middle=0;
        if ((end-start+1)%2==0){
            middle=((start+end)>>1)+1;
        }else {
            middle=(start+end)>>1;
        }
        TreeNode node = new TreeNode(nums[middle]);
        node.left=f(nums,start,middle-1);
        node.right=f(nums,middle+1,end);
        return node;
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
