package leetcode.动态规划;

/**
 * @Date 2021/1/5 23:23
 * @Created by ZhuangJie
 * @Description
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Question70 {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int dp[]=new int[n+1];
        dp[1]=1;dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}
