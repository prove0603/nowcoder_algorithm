package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/20 11:18
 */
/*
    题目描述
        输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    对java引用会有更好的理解
 */
public class JZ16 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode result;
        ListNode min=list1.val>list2.val?list2:list1;
        result=min;
        if (min.val==list1.val){
            list1=list1.next;
        }else {
            list2=list2.next;
        }
        while (list1!=null || list2!=null){
            if (list1==null) {
                min.next=list2;
                list2=list2.next;
            }
            else if (list2==null) {
                min.next=list1;
                list1=list1.next;
            }
            else {
                min.next=list1.val>list2.val?list2:list1;
                if (min.next.val==list1.val){
                    list1=list1.next;
                }else {
                    list2=list2.next;
                }
            }
            min=min.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        ListNode f=new ListNode(6);
        a.next=c;c.next=e;
        b.next=d;d.next=f;
        ListNode tmp=a;
        tmp.next=e;
        e=f;
        System.out.println(tmp.val);
        System.out.println(tmp.next.val);
        System.out.println(a.val);
        System.out.println(a.next.val);
//        System.out.println(Merge(a,b));
    }
}
