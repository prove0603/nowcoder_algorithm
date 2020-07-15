package 剑指Offer;

import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/15 11:13
 */

/*
     String s = String.valueOf(new char[]{'c'}); //将一个baichar数组转换成String
    题目描述
        请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
        但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

    分析：
        1.可以按照是否有e分为两类
        2.不能有除了e E 以外的字符
        3.e E 的前后一定是有效数字（包含正负号） 可以截取前后两个数字 再按照没有e的去判断
        4.没有e: 只能在开头有正负号
        5.只能有一个小数点
 */
public class JZ53 {

    public boolean isNumeric(char[] str) {
        String tatget=String.valueOf(str);
        int countE=0,indexE=-1;
        for (int i = 0; i <tatget.length() ; i++) {
            if (tatget.charAt(i)=='e' || tatget.charAt(i)=='E'){
                countE++;
                if (countE>1) return false;
                indexE=i;
            }
        }
        if (countE==0){
            return isNumber(tatget);
        }else {
            if (indexE==tatget.length()-1) return false;
            boolean first=isNumber(tatget.substring(0,indexE));
            boolean second=isNumber(tatget.substring(indexE+1));
            if (second){
                String tmp=tatget.substring(indexE+1);
                for (int i = 0; i <tmp.length() ; i++) {
                    if(tmp.charAt(i)=='.')
                       second=false;
                }
            }
            if (first && second) return true;
            else return false;
        }
    }

//    不含e
    public boolean isNumber(String a){
        int countDian=0;
        for (int i = 0; i <a.length() ; i++) {
            if (a.charAt(i)>'9' ||a.charAt(i)<'0' ){
                if (a.charAt(i)=='+' ||a.charAt(i)=='-'){
                    if (i!=0)
                        return false;
                }else if (a.charAt(i)=='.'){
                    if (i==0 || i==a.length()-1)
                        return false;
                    countDian++;
                    if (countDian>1)
                        return false;
                }
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JZ53 jz53=new JZ53();
        Scanner in=new Scanner(System.in);
        while (true){
            System.out.println(jz53.isNumeric(in.nextLine().toCharArray()));
        }
    }
}
