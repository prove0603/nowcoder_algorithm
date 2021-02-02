package leetcode.动态规划;

/**
 * @Date 2021/1/7 23:13
 * @Created by ZhuangJie
 * @Description
 * 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * https://leetcode-cn.com/problems/distinct-subsequences/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-27/
 */
public class Question115 {

    public int numDistinct(String s, String t) {
        //dp[i][j]代表 s[0,i)包含多少个t[0,j)  前i个s 包含多少个 前j个t
        int m=s.length();int n=t.length();
        int dp[][]=new int[m+1][n+1];
        dp[0][0]=1;
        for (int i = 1; i <=m ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(j>i) break;
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
//    会超时
//    int counter=0;
//    public int numDistinct(String s, String t) {
//        f(0,"",s,t);
//        return counter;
//    }
//    public void f(int index,String prefix,String s,String t){
//        if (prefix.length()==t.length()){
//            if (prefix.equals(t)){
//                counter++;
//                return;
//            }else {
//                return;
//            }
//        }
//        if (index==s.length()){
//            return;
//        }
//        String tmpA=prefix+s.charAt(index);
//        f(index+1,tmpA,s,t);
//        f(index+1,prefix,s,t);
//    }

    public static void main(String[] args) {
        Question115 question115 = new Question115();
        System.out.println(question115.numDistinct("babgbag","bag"));
    }

}
