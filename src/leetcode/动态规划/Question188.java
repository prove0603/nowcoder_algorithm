package leetcode.动态规划;

/**
 * @Date 2021/1/24 16:02
 * @Created by ZhuangJie
 * @Description
 * 买卖股票的最佳时机 IV
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iv-by-8xtkp/
 */
public class Question188 {
    public int maxProfit(int k, int[] prices) {
        int len=prices.length;
        if (k<1 || len<2){return 0;}
        k=Math.min(k,len/2);
        int buy[][]=new int[len+1][k+1];
        int sell[][]=new int[len+1][k+1];
        buy[1][0]=-prices[0];buy[1][1]=-prices[0];
        for (int i = 2; i <=len ; i++) {
            buy[i][0]=Math.max(buy[i-1][0],-prices[i-1]);
            for (int j = 1; j <=k && i/2 >=j; j++) {
                buy[i][j]=Math.max(buy[i-1][j],sell[i-1][j]-prices[i-1]);
                sell[i][j]=Math.max(sell[i-1][j],buy[i-1][j-1]+prices[i-1]);
            }
        }
        int max=0;
        for (int i = 1; i <=k ; i++) {
            max=Math.max(max,sell[len][i]);
        }
        return max;
    }
}
