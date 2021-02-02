package leetcode.动态规划;

/**
 * @Date 2021/1/5 22:29
 * @Created by ZhuangJie
 * @Description
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Question62 {

    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            dp[i][1]=1;
        }
        for (int i = 1; i <=n ; i++) {
            dp[1][i]=1;
        }
        for (int i = 2; i <=m ; i++) {
            for (int j = 2; j <=n ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Question62 question62=new Question62();
        question62.uniquePaths(3,7);
    }
//    递归会超时
//    public int uniquePaths(int m, int n) {
//        return f(m,n);
//    }
//    public int f(int m,int n){
//        if (m==1 || n==1) return 1;
//        return f(m,n-1)+f(m-1,n);
//    }
}
