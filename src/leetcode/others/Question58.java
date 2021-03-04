package leetcode.others;

/**
 * @Date 2021/2/10 1:22
 * @Created by ZhuangJie
 * @Description
 */
public class Question58 {
    public int lengthOfLastWord(String s) {
        if (s.trim().equals("")) {return 0;}
        s=s.trim();
        int counter=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)!=' '){
                counter++;
            }else {
                break;
            }
        }
        return counter;
    }
}
