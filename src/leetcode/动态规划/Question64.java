package leetcode.动态规划;

/**
 * @Date 2021/1/5 23:08
 * @Created by ZhuangJie
 * @Description
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class Question64 {
    public int minPathSum(int[][] grid) {
        int m= grid.length,n= grid[0].length;
        int dp[][]=new int[m+1][n+1];
        dp[1][1]=grid[0][0];
        for (int i = 2; i <=m ; i++) {
            dp[i][1]=dp[i-1][1]+grid[i-1][0];
        }
        for (int i = 2; i <=n ; i++) {
            dp[1][i]=dp[1][i-1]+grid[0][i-1];
        }
        for (int i = 2; i <=m ; i++) {
            for (int j = 2; j <=n ; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
