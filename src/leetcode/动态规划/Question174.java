package leetcode.动态规划;

/**
 * @Date 2021/1/13 14:52
 * @Created by ZhuangJie
 * @Description 地下城游戏
 * https://leetcode-cn.com/problems/dungeon-game/
 */
public class Question174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;int n=dungeon[0].length;
        // dp[][][0]   dp[][][1]代表上方
        int dp[][][] = new int[m + 1][n + 1][4];
        for (int i = 1; i <= m; i++) {
            dp[i][1][0] = dp[i - 1][1][0] + dungeon[i - 1][0];
            dp[i][1][1] = Math.min(dp[i - 1][1][1], dp[i][1][0]);
            dp[i][1][2] = dp[i][1][0];
            dp[i][1][3] = dp[i][1][1];
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i][0] = dp[1][i - 1][0] + dungeon[0][i - 1];
            dp[1][i][1] = Math.min(dp[1][i - 1][1], dp[1][i][0]);
            dp[1][i][2] = dp[1][i][0];
            dp[1][i][3] = dp[1][i][1];

        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                int current_top0=dp[i-1][j][0]+dungeon[i-1][j-1];
                int current_top1=Math.min(current_top0,dp[i-1][j][1]);
                int current_top2=dp[i-1][j][2]+dungeon[i-1][j-1];
                int current_top3=Math.min(current_top2,dp[i-1][j][3]);
                if (current_top1>current_top3){
                    dp[i][j][0]=current_top0;
                    dp[i][j][1]=current_top1;
                }else if (current_top1<current_top3){
                    dp[i][j][0]=current_top2;
                    dp[i][j][1]=current_top3;
                }else {
                    dp[i][j][0]=Math.max(current_top0,current_top2);
                    dp[i][j][1]=current_top1;
                }
                int current_left0=dp[i][j-1][0]+dungeon[i-1][j-1];
                int current_left1=Math.min(current_left0,dp[i][j-1][1]);
                int current_left2=dp[i][j-1][2]+dungeon[i-1][j-1];
                int current_left3=Math.min(current_left2,dp[i][j-1][3]);
                if (current_left1>current_left3){
                    dp[i][j][2]=current_left0;
                    dp[i][j][3]=current_left1;
                }else if (current_left1<current_left3){
                    dp[i][j][2]=current_left2;
                    dp[i][j][3]=current_left3;
                }else {
                    dp[i][j][2]=Math.max(current_left0,current_left2);
                    dp[i][j][3]=current_left1;
                }
            }
        }
        int max=Math.max(dp[m][n][1],dp[m][n][3]);
        if (max>=0) return 0;
        else return -max+1;
    }

    /**

     */

    /*
     int m=dungeon.length;int n=dungeon[0].length;
        int dp[][]=new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            dp[i][1]=Math.min(dp[i-1][1],dp[i-1][1]+dungeon[i-1][0]);
        }
        for (int i = 1; i <=n ; i++) {
            dp[1][i]=Math.min(dp[1][i-1],dp[1][i-1]+dungeon[0][i-1]);
        }
        for (int i = 2; i <=m ; i++) {
            for (int j = 2; j <=n ; j++) {
                int tmp=Math.max(dp[i-1][j],dp[i][j-1]);
                dp[i][j]=Math.min(tmp,tmp+ dungeon[i-1][j-1]);
            }
        }
        return dp[m][n];
     */
}
