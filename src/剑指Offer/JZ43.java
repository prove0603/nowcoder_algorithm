package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/16 13:46
 */

    /*
        题目描述
            汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
            对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
            例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

     */
public class JZ43 {
    public String LeftRotateString(String str,int n) {
        if (str.equals("") || str==null) return "";
        if (n==0 || n==str.length()) return str;
        if (n>str.length()) n=n-str.length();
        String tmp=str.substring(0,n);
        String left=str.substring(n,str.length());
        String newString=left+tmp;
        return newString;
    }

    public static void main(String[] args) {
        JZ43 jz43=new JZ43();
        System.out.println(jz43.LeftRotateString(new String(),3));
    }
}
