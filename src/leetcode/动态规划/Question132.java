package leetcode.动态规划;

/**
 * @Date 2021/1/11 17:20
 * @Created by ZhuangJie
 * @Description
 * 分割回文串 II
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 */
public class Question132 {
    public int minCut(String s) {
        int len=s.length();
        if (len<1) {return 0;}
        int helper[][]=new int[len+1][len+1];
        for (int j = 1; j <=len ; j++) {
            for (int i = 1; i <=j ; i++) {
                if (s.charAt(j-1)==s.charAt(i-1)){
                    if (j-i<3){
                        helper[i][j]=1;
                    }else {
                        helper[i][j]=helper[i+1][j-1];
                    }
                }else {
                    helper[i][j]=0;
                }
            }
        }
        int dp[]=new int[len+1];
        for (int i = 1; i <=len ; i++) {
            dp[i]=i;
        }
        for (int j = 1; j <=len ; j++) {
            if (helper[1][j]==1){
                dp[j]=0;
            }else {
                for (int i = 2; i <=j ; i++) {
                    if (helper[i][j]==1){
                        dp[j]=Math.min(dp[j],dp[i-1]+1);
                    }
                }
            }
        }
        return dp[len];
    }
}
