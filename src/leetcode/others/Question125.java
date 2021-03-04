package leetcode.others;

/**
 * @Date 2021/2/18 1:23
 * @Created by ZhuangJie
 * @Description
 */
public class Question125 {
    public boolean isPalindrome(String s) {
        if(s.equals("")) {return true;}
        int start=0,end=s.length()-1;
        while (start<end){
            while (start<end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while (start<end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if (s.charAt(start)==s.charAt(end) ||
                    Character.toLowerCase(s.charAt(start))==Character.toLowerCase(s.charAt(end))){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('a'-0);
        System.out.println('A'-0);
    }
}
