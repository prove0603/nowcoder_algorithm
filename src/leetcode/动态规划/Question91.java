package leetcode.动态规划;

/**
 * @Date 2021/1/6 22:58
 * @Created by ZhuangJie
 * @Description
 * 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class Question91 {
    public int numDecodings(String s) {
        int len=s.length();
        if (s.equals("0") || s.charAt(0)=='0') return 0;
        if (len==1) return 1;
        int dp[]=new int[len+1];
        dp[0]=1;dp[1]=1;
        for (int i = 2; i <=len ; i++) {
            if (s.charAt(i-1)=='0'){
                if (s.charAt(i-2)=='0'){
                    dp[len]=0;
                    break;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s.charAt(i-2));
                stringBuilder.append(s.charAt(i-1));
                if (Integer.parseInt(stringBuilder.toString())<=26){
                    dp[i]=dp[i-2];
                }else {
                    dp[len]=0;
                    break;
                }
            }else {
                if (s.charAt(i-2)!='0'){
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(s.charAt(i-2));
                    stringBuilder.append(s.charAt(i-1));
                    if (Integer.parseInt(stringBuilder.toString())<=26){
                        dp[i]=dp[i-1]+dp[i-2];
                    }else {
                        dp[i]=dp[i-1];
                    }
                }else {
                    dp[i]=dp[i-1];
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Question91 question91 = new Question91();
        System.out.println(question91.numDecodings("1123"));
    }
}
