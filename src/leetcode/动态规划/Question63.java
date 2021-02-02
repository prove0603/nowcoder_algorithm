package leetcode.动态规划;

/**
 * @Date 2021/1/5 22:43
 * @Created by ZhuangJie
 * @Description
 * 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class Question63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1) return 0;
        int dp[][]=new int[m+1][n+1];
        dp[0][1]=1;dp[1][0]=1;
        for (int i = 1; i <=m ; i++) {
            if(obstacleGrid[i-1][0]==0 && dp[i-1][1]==1){
                dp[i][1]=1;
            }
        }
        for (int i = 1; i <=n ; i++) {
            if(obstacleGrid[0][i-1]==0 && dp[1][i-1]==1){
                dp[1][i]=1;
            }
        }
        for (int i = 2; i <=m ; i++) {
            for (int j = 2; j <=n ; j++) {
                if(obstacleGrid[i-1][j-1]==1) continue;
                if (obstacleGrid[i-2][j-1]!=1 ){
                    dp[i][j]+=dp[i-1][j];
                }
                if (obstacleGrid[i-1][j-2]!=1){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
