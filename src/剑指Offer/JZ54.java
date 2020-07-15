package 剑指Offer;

import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/15 10:29
 */
    /*
        题目描述
            请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
            第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
            输出描述:

            如果当前字符流没有存在出现一次的字符，返回#字符。

     */
public class JZ54 {
    //Insert one char from stringstream
    //可以用队列存储符合条件的char  之后判断队列里的元素就行  避免每次都遍历全部的arr元素

    public static char arr[]=new char[10000];
    public static int counter[]=new int[10000];
    public static int index=0;

    public void Insert(char ch) {
        arr[index]=ch;
        index++;
        counter[ch]++;
    }
    //return the first appearence once char in current stringstream

    public char FirstAppearingOnce() {
        for (int i = 0; i <arr.length ; i++) {
            if (counter[arr[i]]==1){
                return arr[i];
            }
        }
        return '#';
    }

    public static void main(String[] args) {

    }
}
