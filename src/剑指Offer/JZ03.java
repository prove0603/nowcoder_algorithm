package 剑指Offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 10:00
 */

/*
    题目描述
        输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class JZ03 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
//  数组保存再反转数组
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        if (listNode==null) return arrayList;
//        while (listNode!=null){
//            arrayList.add(listNode.val);
//            listNode=listNode.next;
//        }
//        Collections.reverse(arrayList);
//        return arrayList;
//    }

//    递归
//    public static ArrayList<Integer> arrayList;
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
//        arrayList=new ArrayList<>();
//        f(listNode);
//        return arrayList;
//    }
//    public static void f(ListNode listNode){
//        if (listNode==null) return ;
//        f(listNode.next);
//        arrayList.add(listNode.val);
//    }

//    用栈
}
