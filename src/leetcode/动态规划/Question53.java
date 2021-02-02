package leetcode.动态规划;

/**
 * @Date 2021/1/5 0:10
 * @Created by ZhuangJie
 * @Description 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Question53 {
    public int maxSubArray(int[] nums) {
        if (nums.length==1) return nums[0];
        int dp[]=new int[nums.length];
        dp[0]= nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length ; i++) {
            dp[i] = Integer.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i]>max) max=dp[i];
        }
        return max;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
