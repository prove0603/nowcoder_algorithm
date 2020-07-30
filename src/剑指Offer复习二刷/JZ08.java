package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 17:43    二刷成功
 */

    /*
        题目描述
            一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
    */
public class JZ08 {

    //  方法一 递归
    //  方法二 循环
    public static int JumpFloor(int target) {
        if (target==0)   return 0;
        if (target==1)   return 1;
        int a=1,b=1,c=0;
        for (int i = 2; i <=target ; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
