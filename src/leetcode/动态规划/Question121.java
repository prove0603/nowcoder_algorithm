package leetcode.动态规划;

import java.util.Stack;

/**
 * @Date 2021/1/8 0:37
 * @Created by ZhuangJie
 * @Description
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Question121 {
    public int maxProfit(int[] prices) {
        if (prices.length==1 || prices.length==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.add(prices[0]);
        int max=0;
        for (int i = 1; i <prices.length ; i++) {
            if (prices[i]<=stack.peek()){
                stack.add(prices[i]);
            }else {
                max=Math.max(max,prices[i]-stack.peek());
            }
        }
        return max;
    }
}
