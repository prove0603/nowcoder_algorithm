package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/13 15:03
 */
public class JZ48 {
    /*
    题目描述
        写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
//    https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215?answerType=1&f=discussion
//
    public int Add(int num1,int num2) {
        while (num2!=0){
            int c=(num1 & num2)<<1; //进位
            num1=num1^num2; // 不进位和
            num2=c;
        }
        return num1;
    }
}
