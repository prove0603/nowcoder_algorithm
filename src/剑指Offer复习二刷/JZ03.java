package 剑指Offer复习二刷;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 15:53    二刷成功
 */
    /*
        题目描述
            输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
    */
public class JZ03 {

    static class ListNode {
        int val;
        ListNode next = null;
            ListNode(int val) {
            this.val = val;
        }
    }

//    方法一   插入数组再倒置
//    方法二   递归
//    方法三   栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (listNode==null) return arrayList;
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode a= new ListNode(1);
        ListNode b= new ListNode(2);
        ListNode c= new ListNode(3);
        ListNode d= new ListNode(4);
        a.next=b;b.next=c;c.next=d;
        JZ03 jz03=new JZ03();
        ArrayList<Integer> arrayList =jz03.printListFromTailToHead(a);

    }
}
