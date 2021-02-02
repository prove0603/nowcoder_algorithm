package leetcode.栈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Date 2020/12/15 2:35
 * @Created by ZhuangJie
 * @Description 基本计算器
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class Question224 {

    public int calculate(String s) {
        Stack<Integer> stackNum = new Stack<>();
        Stack<Character> stackOp = new Stack<>();

        char[] array = s.toCharArray();
        int sign=-1;
        for (int i = 0; i <array.length ; i++) {
            if(array[i]==' ') continue;
            if (isDigit(array[i])){
                if (sign==-1){
                    sign=array[i]-'0';
                }else {
                    sign=sign*10+(array[i]-'0');
                }
            }else {
                if (sign!=-1){
                    stackNum.push(sign);
                    sign=-1;
                }
                if (isOperation(array[i])){
                    HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
                    if (!stackOp.isEmpty()){
                        if (stackOp.peek()=='(') {}
                        else {
                            int num1=stackNum.pop();
                            int num2=stackNum.pop();
                            if (stackOp.pop()=='+'){
                                stackNum.push(num1+num2);
                            }else{
                                stackNum.push(num2-num1);
                            }
                        }
                    }
                    stackOp.push(array[i]);
                }else {
                    if (array[i]=='('){
                        stackOp.push(array[i]);
                    }else {
                        while (stackOp.peek()!='('){
                            int num1=stackNum.pop();
                            int num2=stackNum.pop();
                            if (stackOp.pop()=='+'){
                                stackNum.push(num1+num2);
                            }else{
                                stackNum.push(num2-num1);
                            }
                        }
                        stackOp.pop();
                    }
                }
            }
        }
        if (sign!=-1) {stackNum.push(sign);}
        while (!stackOp.isEmpty()){
            int num1=stackNum.pop();
            int num2=stackNum.pop();
            if (stackOp.pop()=='+'){
                stackNum.push(num1+num2);
            }else{
                stackNum.push(num2-num1);
            }
        }
        return stackNum.pop();
    }

    public boolean isDigit(char s) {
        return (s >= '0' && s <= '9');
    }

    public boolean isOperation(char s) {
        return (s == '+' || s == '-');
    }

    public static void main(String[] args) {
        Question224 question224=new Question224();
        System.out.println(question224.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    /*
    public int calculate(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        int temp = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == ' ') {
                continue;
            }
            // 数字进行累加
            if (isNumber(array[i])) {
                if (temp == -1) {
                    temp = array[i] - '0';
                } else {
                    temp = temp * 10 + array[i] - '0';
                }
            } else {
                //将数字入栈
                if (temp != -1) {
                    num.push(temp);
                    temp = -1;
                }
                //遇到操作符
                if (isOperation(array[i] + "")) {
                    while (!op.isEmpty()) {
                        if (op.peek() == '(') {
                            break;
                        }
                        //不停的出栈，进行运算，并将结果再次压入栈中
                        int num1 = num.pop();
                        int num2 = num.pop();
                        if (op.pop() == '+') {
                            num.push(num1 + num2);
                        } else {
                            num.push(num2 - num1);
                        }
                    }
                    //当前运算符入栈
                    op.push(array[i]);
                } else {
                    //遇到左括号，直接入栈
                    if (array[i] == '(') {
                        op.push(array[i]);
                    }
                    //遇到右括号，不停的进行运算，直到遇到左括号
                    if (array[i] == ')') {
                        while (op.peek() != '(') {
                            int num1 = num.pop();
                            int num2 = num.pop();
                            if (op.pop() == '+') {
                                num.push(num1 + num2);
                            } else {
                                num.push(num2 - num1);
                            }
                        }
                        op.pop();
                    }

                }
            }
        }
        if (temp != -1) {
            num.push(temp);
        }
        //将栈中的其他元素继续运算
        while (!op.isEmpty()) {
            int num1 = num.pop();
            int num2 = num.pop();
            if (op.pop() == '+') {
                num.push(num1 + num2);
            } else {
                num.push(num2 - num1);
            }
        }
        return num.pop();
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperation(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }

     */
}
