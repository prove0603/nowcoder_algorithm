package leetcode.动态规划;

/**
 * @Date 2021/1/24 15:28
 * @Created by ZhuangJie
 * @Description
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Question198 {
    public int rob(int[] nums) {
        int len= nums.length;
        if (len==0) {return 0;}
        int dp[][]=new int[len+1][2];
        for (int i = 1; i <=len ; i++) {
            dp[i][0]=dp[i-1][1];
            dp[i][1]=dp[i-1][0]+nums[i-1];
        }
        return Math.max(dp[len][0],dp[len][1]);
    }
}
