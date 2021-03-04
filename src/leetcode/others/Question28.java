package leetcode.others;

/**
 * @Date 2021/2/10 0:28
 * @Created by ZhuangJie
 * @Description
 */
public class Question28 {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")) {return 0;}
        int len=needle.length();
        for (int i = 0; i <haystack.length() ; i++) {
            if (i+len>=haystack.length()) {return -1;}
            if (haystack.charAt(i)==needle.charAt(0)){
                String tmp=haystack.substring(i,i+len);
                if (tmp.equals(needle)) {return i;}
            }
        }
        return -1;
    }
}
