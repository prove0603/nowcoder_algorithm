package leetcode.动态规划;

/**
 * @Date 2020/12/30 1:06
 * @Created by ZhuangJie
 * @Description
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class Question5 {
    public String longestPalindrome(String s) {
        if (s.length()<2) return s;
        boolean arr[][]=new boolean[s.length()][s.length()];
        for (int i = 0; i <s.length() ; i++) {
            arr[i][i]=true;
        }
        int maxLength=0;
        int begin=0;
        for (int j = 1; j <s.length() ; j++) {
            for (int i = 0; i <j ; i++) {
                if (s.charAt(j)==s.charAt(i)){
                    if (j-i<3){
                        arr[i][j]=true;
                    }else {
                        arr[i][j]=arr[i+1][j-1];
                    }
                }else {
                    arr[i][j]=false;
                }
                if (arr[i][j]==true){
                    if (j-i+1>maxLength){
                        maxLength=j-i+1;
                        begin=i;
                    }
                }
            }
        }
        return s.substring(begin,begin+maxLength);
    }
}
