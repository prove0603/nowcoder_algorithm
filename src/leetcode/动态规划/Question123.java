package leetcode.动态规划;

/**
 * @Date 2021/1/11 16:11
 * @Created by ZhuangJie
 * @Description
 * 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/123-mai-mai-gu-piao-de-zui-jia-shi-ji-ii-zfh9/
 */
public class Question123 {
    //dp[i][1]，表示的是第i天，买入股票的状态，并不是说一定要第i天买入股票，这是很多同学容易陷入的误区。
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if (len<4) {return 0;}
        int dp[][]=new int[len+1][5];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        dp[0][3]=-prices[0];
        dp[0][4]=0;
        for (int i = 1; i <=len ; i++) {
            dp[i][1]=Math.max(dp[i-1][0]-prices[i-1],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i-1][1]+prices[i-1],dp[i-1][2]);
            dp[i][3]=Math.max(dp[i-1][2]-prices[i-1],dp[i-1][3]);
            dp[i][4]=Math.max(dp[i-1][3]+prices[i-1],dp[i-1][4]);
        }
        return dp[len][4];
    }
}
