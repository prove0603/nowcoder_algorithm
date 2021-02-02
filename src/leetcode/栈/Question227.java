package leetcode.栈;

import java.util.Stack;

/**
 * @Date 2020/12/15 22:28
 * @Created by ZhuangJie
 * @Description
 */
public class Question227 {
    public int calculate(String s) {
        char[] array = s.toCharArray();
        Stack<Integer> stackNum = new Stack<Integer>();
        Stack<Character> stackOp = new Stack<Character>();
        int tmp=-1;
        int sign=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==' ') continue;
            if (!isOp(array[i])){
                if (tmp==-1){
                    tmp=array[i]-'0';
                }else {
                    tmp=tmp*10+(array[i]-'0');
                }
            }else {
                if (sign==0) stackNum.push(tmp);
                if (sign==-1) {stackNum.push(-tmp);sign=0;}
                tmp=-1;
                while (!stackOp.isEmpty()){
                    if (stackOp.peek()=='*'){
                        stackOp.pop();
                        int num1=stackNum.pop();
                        int num2=stackNum.pop();
                        int result=num1*num2;
                        stackNum.push(result);
                    }else {
                        stackOp.pop();
                        int num1=stackNum.pop();
                        int num2=stackNum.pop();
                        int result=num2/num1;
                        stackNum.push(result);
                    }
                }
                if (array[i]=='+') sign=0;
                if (array[i]=='-') sign=-1;
                if (array[i]=='*')  stackOp.push(array[i]);
                if (array[i]=='/')  stackOp.push(array[i]);
            }
        }
        if (tmp!=-1){
            if (sign==0) stackNum.push(tmp);
            if (sign==-1) stackNum.push(-tmp);
        }
        while (!stackOp.isEmpty()){
            if (stackOp.peek()=='*'){
                stackOp.pop();
                int num1=stackNum.pop();
                int num2=stackNum.pop();
                int result=num1*num2;
                stackNum.push(result);
            }else {
                stackOp.pop();
                int num1=stackNum.pop();
                int num2=stackNum.pop();
                int result=num2/num1;
                stackNum.push(result);
            }
        }
        int res=0;
        for (int i = 0; i <stackNum.size() ; i++) {
            res+=stackNum.get(i);
        }
        return res;
    }

    public boolean isOp(char s){
        if (s=='*' || s=='/' || s=='+' || s=='-') return true;
        else return false;
    }

    public static void main(String[] args) {
        Question227 question227=new Question227();
        System.out.println(question227.calculate("12-3*4"));
    }
    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     *
     * 示例 1:
     *
     * 输入: "3+2*2"
     * 输出: 7
     * 示例 2:
     *
     * 输入: " 3/2 "
     * 输出: 1
     * 示例 3:
     *
     * 输入: " 3+5 / 2 "
     * 输出: 5
     * 说明：
     *
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
