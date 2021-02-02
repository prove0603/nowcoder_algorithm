package leetcode.动态规划;

/**
 * @Date 2021/1/7 22:20
 * @Created by ZhuangJie
 * @Description
 * 交错字符串
 * https://leetcode-cn.com/problems/interleaving-string/
 */
public class Question97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length();int n=s2.length();
        if(m+n!=s3.length()) return false;
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int j = 1; j <=n ; j++) {
            if (s2.charAt(j-1)==s3.charAt(j-1) ){
                dp[0][j]=true;
            }else {
                break;
            }
        }
        for (int i = 1; i <=m ; i++) {
            if (s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0]=true;
            }else {
                break;
            }
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j]=(dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1))
                        || (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[m][n];
    }
}
