package 笔试真题.顺丰科技汇总;

/**
 * @Date 2021/3/4 22:09
 * @Created by ZhuangJie
 * @Description
 * 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if(len==1) return 1;
        int dp[]=new int[len+1];
        int tail
        dp[1]=1;
        int max=Integer.MIN_VALUE;
        for (int i = 2; i < dp.length; i++) {
            for (int j = i-2; j >=0; j--) {
                if(nums[j]<nums[i-1]){
                    dp[i]=Integer.max(dp[j+1]+1,dp[i]);
                }
            }
            if(dp[i]==0) dp[i]=1;
            if(dp[i]>max){max= dp[i];}
        }
        return max;
    }
}
