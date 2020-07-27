package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/27 17:13
 */

/*
    题目描述
        输入一个链表，输出该链表中倒数第k个结点。

 */
public class JZ14 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (k<=0) return null;
        int length=0;
        ListNode tmp=head;
        while (tmp!=null){
            length++;
            tmp=tmp.next;
        }
        if (k>length) return null;
        int target=length-k+1;
        int counter=0;
        while (head!=null){
            counter++;
            if (counter==target) return head;
            head=head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        JZ14 jz14=new JZ14();
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        a.next=b;b.next=c;c.next=d;d.next=e;
        System.out.println(jz14.FindKthToTail(a,1).val);
    }
}
