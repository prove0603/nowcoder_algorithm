package leetcode.贪心算法;

/**
 * @Date 2021/1/27 0:53
 * @Created by ZhuangJie
 * @Description
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Question122 {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if (len==1) {return 0;}
        int dp[][]=new int[len+1][2];
//        dp[][0] 代表手上没股票(没买或者今天卖掉了)  dp[][1] 代表手上有股票  昨天的或者今天刚买的
        dp[1][0]=0;dp[1][1]=-prices[0];
        for (int i = 2; i <=len ; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i-1]);
        }
        return Math.max(dp[len][0],dp[len][1]);
    }
}
