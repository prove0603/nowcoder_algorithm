package leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/1/9 22:57
 * @Created by ZhuangJie
 * @Description
 * 分割回文串
 *  https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class Question131 {
    int dp[][];
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        int len=s.length();
        result=new ArrayList<>();
        if (len==0) {return result;}
        dp=new int[len+1][len+1];
        for (int i = 1; i <=len ; i++) {
            dp[i][i]=1;
        }
        for (int j = 2; j <=len ; j++) {
            for (int i = 1; i <=j ; i++) {
                if (s.charAt(j-1)==s.charAt(i-1)){
                    if (j-i-3<0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        f(s,1,new ArrayList<String>());
        return result;
    }

    public void f(String s,int current,ArrayList<String> list){
        if (current==s.length()+1){
            result.add((List<String>) list.clone());
            return;
        }
        for (int i = current; i <=s.length() ; i++) {
            if (dp[current][i]==1 ){
                list.add(s.substring(current-1,i-1+1));
                f(s,i+1,list);
                list.remove(list.size()-1);
            }
        };
    }

    public static void main(String[] args) {
        Question131 question131 = new Question131();
        question131.partition("aab");
    }
}
