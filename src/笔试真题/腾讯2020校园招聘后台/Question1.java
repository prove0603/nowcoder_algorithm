package 笔试真题.腾讯2020校园招聘后台;

import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/13 9:26
 */

/*
 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，
 现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？

输入描述:

输入第一行包含一个字符串s，代表压缩后的字符串。
S的长度<=1000;
S仅包含大写字母、[、]、|;
解压后的字符串长度不超过100000;
压缩递归层数不超过10层;


输出描述:

输出一个字符串，代表解压后的字符串。


输入例子1:

HG[3|B[2|CA]]F


输出例子1:

HGBCACABCACABCACAF


例子说明1:

HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF

1.找到最内层的[]  解压
 */
public class Question1 {

    public static String f(String str) {
        int innerFoot = str.indexOf("]");
        int innerHead = str.lastIndexOf("[",innerFoot);
        if (innerHead == -1) return str;
        int middle = str.indexOf("|", innerHead);//找到对应的 "|"
        if (middle==-1) return str;
        int number = Integer.parseInt(str.substring(innerHead + 1, middle));//数字
        String tmp = str.substring(middle + 1, innerFoot);//需要解压的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <number; i++) {
            stringBuilder.append(tmp);
        }
        String newString = str.substring(0, innerHead) +stringBuilder.toString()+str.substring(innerFoot+1);
        return f(newString);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(f(str));
    }
}
