package 剑指Offer;


import java.util.Stack;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/27 15:17
 */

/*
    题目描述
        定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

 */
public class JZ20 {

    public static Stack<Integer> stack=new Stack<>();
    public static Stack<Integer> helper=new Stack<>();
    static int min=Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node<=min){
            helper.push(node);
            min=node;
        }
    }

    public void pop() {
        int pop=stack.pop();
        if (pop==helper.peek()){
            helper.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helper.peek();

    }

    public static void main(String[] args) {
        JZ20 jz20=new JZ20();
//        ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
        jz20.push(3);
        System.out.println(jz20.min());
        jz20.push(4);
        System.out.println(jz20.min());
        jz20.push(2);
        System.out.println(jz20.min());
        jz20.push(3);
        System.out.println(jz20.min());
        jz20.pop();
        System.out.println(jz20.min());
        jz20.pop();
        System.out.println(jz20.min());
        jz20.pop();
        System.out.println(jz20.min());
        jz20.push(0);
        System.out.println(jz20.min());
    }
}
