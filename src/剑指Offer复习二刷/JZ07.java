package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 17:39    二刷成功
 */
/*
    题目描述
        大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
        n<=39
 */
public class JZ07 {

//  方法一 递归
//  方法二 循环
    public int Fibonacci(int n) {
        if (n==0)   return 0;
        if (n==1)   return 1;
        int a=0,b=1,c=0;
        for (int i = 2; i <=n ; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
