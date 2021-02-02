package leetcode.动态规划;

/**
 * @Date 2021/1/6 0:44
 * @Created by ZhuangJie
 * @Description
 * 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 * 题解： https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
 */
public class Question72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        int dp[][]=new int[m+1][n+1];
        for (int i = 1; i <=n ; i++) {
            dp[0][i]=dp[0][i-1]+1;
        }
        for (int i = 1; i <=m ; i++) {
            dp[i][0]=dp[i-1][0]+1;
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }
}
