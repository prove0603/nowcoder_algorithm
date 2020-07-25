package 剑指Offer;

import java.util.HashSet;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/25 9:14
 */
/*
        题目描述
            在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
            并返回它的位置,如果没有则返回 -1（需要区分大小写）.（从0开始计数）

 */
public class JZ34 {
    public int FirstNotRepeatingChar(String str) {
        HashSet<Character> set=new HashSet<>();
        int arr[]=new int[200];
        int size=0;
        for (int i = 0; i <str.length() ; i++) {
            set.add(str.charAt(i));
            if (size==set.size()){
                arr[str.charAt(i)]=1;
            }
            size=set.size();
        }
        for (int i = 0; i < str.length();  i++) {
            if (arr[str.charAt(i)]==0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JZ34 jz34=new JZ34();
        System.out.println(jz34.FirstNotRepeatingChar(""));
    }
}
