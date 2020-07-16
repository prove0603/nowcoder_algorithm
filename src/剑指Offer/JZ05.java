package 剑指Offer;

import java.util.Stack;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/14 11:44
 * page 68
 */

/*
    用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class JZ05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.isEmpty()){
            int tmp=stack1.pop();
            stack2.push(tmp);
        }
        stack2.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            int tmp=stack1.pop();
            stack2.push(tmp);
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        JZ05 jz05=new JZ05();
        jz05.push(1);
        jz05.push(2);
        jz05.push(3);
        System.out.println(jz05.pop());
        jz05.push(4);
        System.out.println(jz05.pop());
        System.out.println(jz05.pop());
    }
}


/*
链接：https://www.nowcoder.com/questionTerminal/54275ddae22f475981afa2244dd448c6?answerType=1&f=discussion
class Solution
{
public:
    void push(int node) {
        stack2.push(node);
    }

    int pop() {
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }

private:
    stack<int> stack1;
    stack<int> stack2;
};
 */