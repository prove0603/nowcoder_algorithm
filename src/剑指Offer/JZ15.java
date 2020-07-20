package 剑指Offer;

import java.util.ArrayList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/20 14:39
 */

/*
    题目描述
        输入一个链表，反转链表后，输出新链表的表头。

    对java引用会有更好的理解
 */
public class JZ15 {
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

//    简化版
    public ListNode ReverseList(ListNode head) {
        ListNode current=null;
        ListNode last=null;
        ListNode reverseFirst=null;
        while (head!=null){
            current=head.next;
            reverseFirst=head;
            reverseFirst.next=last;
            last=head;
            head=current;
        }
        return reverseFirst;
    }

//    非简化版
//    public ListNode ReverseList(ListNode head) {
//        if (head==null) return null;
//        ArrayList<ListNode> list=new ArrayList<>();
//        while (head!=null){
//            ListNode tmp=new ListNode(head.val);
//            list.add(tmp);
//            head=head.next;
//        }
//        for (int i = list.size()-1; i>=1 ; i--) {
//            list.get(i).next=list.get(i-1);
//        }
//        return list.get(list.size()-1);
//    }
}