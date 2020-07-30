package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/30 14:07    二刷成功
 */
    /*
        题目描述
            输入一个链表，反转链表后，输出新链表的表头。
    */
public class JZ15 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
//      其实就是头插法
    public ListNode ReverseList(ListNode head) {
        if (head==null) return null;
        ListNode reverseHead=new ListNode(head.val);
        while (head.next!=null){
            head=head.next;
            ListNode tmp=new ListNode(head.val);
            tmp.next=reverseHead;
            reverseHead=tmp;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        a.next=b;b.next=c;c.next=d;
        JZ15 jz15=new JZ15();
        ListNode result=jz15.ReverseList(a);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
    }
}
