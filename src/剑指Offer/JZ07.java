package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/21 9:10
 */
    /*
        题目描述
            大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
            n<=39
    */
public class JZ07 {
//    普通递归
//    public int Fibonacci(int n) {
//        if (n==0) return 0;
//        if (n==1) return 1;
//        return Fibonacci(n-1)+Fibonacci(n-2);
//    }


//    循环
    public int Fibonacci(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int a=0,b=1,c=0;
        for (int i = 2; i <=n ; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }


    public static void main(String[] args) {
        JZ07 jz07=new JZ07();
        System.out.println(jz07.Fibonacci(39));
    }
}
