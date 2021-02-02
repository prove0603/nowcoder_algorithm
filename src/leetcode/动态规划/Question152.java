package leetcode.动态规划;

/**
 * @Date 2021/1/12 16:37
 * @Created by ZhuangJie
 * @Description
 * 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */

public class Question152 {
    public int maxProduct(int[] nums) {
        int len= nums.length;
        if (len==1) { return nums[0]; }
//        dp[][0] 代表正数情况下的最大值（绝对数） dp[][1]代表负数情况下的最大值(绝对数)
        int dp[][]=new int[len+1][2];
        if (nums[0]>=0){
            dp[1][0]=nums[0];
        }else {
            dp[1][1]=nums[0];
        }
        int max=dp[1][0];
        for (int i = 2; i <=len ; i++) {
            if (nums[i-1]>=0){
                dp[i][0]=Integer.max(dp[i-1][0]*nums[i-1],nums[i-1]);
                dp[i][1]=Integer.min(dp[i-1][1]*nums[i-1],nums[i-1]);
            }else {
                dp[i][0]=Integer.max(dp[i-1][1]*nums[i-1],nums[i-1]);
                dp[i][1]=Integer.min(dp[i-1][0]*nums[i-1],nums[i-1]);
            }
            max=Math.max(dp[i][0],max);
        }
        return max;
    }
}
