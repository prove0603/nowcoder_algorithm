package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/30 11:46
 */

/*
    题目描述
        输入一个链表，输出该链表中倒数第k个结点。
 */

public class JZ14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //倒数第n个结点就是到null距离为n的结点
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null) return null;
        int n=k;
        ListNode tmp=head;
        while (n>0 && tmp!=null){
            tmp=tmp.next;
            n--;
        }
        if (n!=0) return null;  //k大于长度
        while (tmp!=null){
            head=head.next;
            tmp=tmp.next;
        }
        return head;
    }
}
