package leetcode.others;

/**
 * @Date 2021/2/3 1:21
 * @Created by ZhuangJie
 * @Description
 */
public class Question9 {
    public boolean isPalindrome(int x) {
        if (x==0) {return true;}
        String a=x+"";
        int start=0,end=a.length()-1;
        while (start<end){
            if (a.charAt(start)!=a.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
