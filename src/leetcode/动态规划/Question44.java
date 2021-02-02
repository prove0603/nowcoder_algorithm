package leetcode.动态规划;

/**
 * @Date 2020/12/29 21:30
 * @Created by ZhuangJie
 * @Description
 * 通配符匹配
 * https://leetcode-cn.com/problems/wildcard-matching/
 * 题解：https://leetcode-cn.com/problems/wildcard-matching/solution/dong-tai-gui-hua-dai-zhu-shi-by-tangweiqun/
 */
public class Question44 {

    public boolean isMatch(String s, String p) {
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 1; i <=p.length() ; i++) {
            dp[0][i]=dp[0][i-1] && p.charAt(i-1)=='*';
        }
        for (int i = 1; i <=s.length() ; i++) {
            for (int j = 1; j <=p.length() ; j++) {
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
//    复杂度高
//    /*
//        1.判断是否是字符  是的话看能否匹配  然后坐标后移
//        2.如果是？  判断是否匹配  能得话坐标后移
//        3.如果是*
//            3.1 匹配一个  然后坐标都向后移动
//            3.2 匹配一个  但是indexP不移动 indexS移动
//            3.3 不匹配 跳过   indexP移动 indexS不移动
//     */
//    public boolean isMatch(String s, String p) {
//        return f(s,p,0,0);
//    }
//
//    public boolean f(String s,String p,int indexS,int indexP){
//        if (indexS==s.length() && indexP==p.length()){
//            return true;
//        }
//        if (indexP==p.length() && indexS<s.length() || indexS>s.length()){
//            return false;
//        }
//        if (isChar(p.charAt(indexP))){
//            if (indexS<s.length() && p.charAt(indexP)==s.charAt(indexS)){
//                return f(s,p,indexS+1,indexP+1);
//            }else {
//                return false;
//            }
//        }else {
//            if (p.charAt(indexP)=='?'){
//                return f(s,p,indexS+1,indexP+1);
//            }else {
//                return (f(s,p,indexS+1,indexP+1) || f(s,p,indexS+1,indexP) || f(s,p,indexS,indexP+1));
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Question44 question44 = new Question44();
//        System.out.println(question44.isMatch("adceb","*a*b"));
//    }
//    public boolean isChar(char c){
//        if (c!='?' && c!='*'){
//            return true;
//        }else {
//            return false;
//        }
//    }

}
