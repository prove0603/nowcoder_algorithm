package leetcode.动态规划;

/**
 * @Date 2021/1/4 21:38
 * @Created by ZhuangJie
 * @Description
 * 10. 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class Question10 {
    public boolean isMatch(String s, String p) {
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 1; i <p.length() ; i++) {
            if (p.charAt(i)=='*' && dp[0][i-1]){
                dp[0][i+1]=true;
            }
        }
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=p.length() ; j++) {
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    if (j-2>=0){
                        if (p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.'){
                            dp[i][j]=dp[i-1][j];
                        }
                        dp[i][j] |=dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
