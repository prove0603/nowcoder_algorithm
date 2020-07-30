package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/30 14:55    二刷成功
 */

/*
    题目描述
        输入两个单调递增的链表，输出两个链表合成后的链表，
        当然我们需要合成后的链表满足单调不减规则。
 */
public class JZ16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode result=new ListNode(-1);
        while (list1!=null && list2!=null){
            ListNode tmp=null;
            if (list1.val>=list2.val){
                tmp=new ListNode(list2.val);
                list2=list2.next;
            }else {
                tmp=new ListNode(list1.val);
                list1=list1.next;
            }
            ListNode node=result;
            while (node.next!=null){
                node=node.next;
            }
            node.next=tmp;
        }
        if (list1==null){
            while (list2!=null){
                ListNode node=result;
                while (node.next!=null){
                    node=node.next;
                }
                node.next=new ListNode(list2.val);
                list2=list2.next;
            }
        }else {
            while (list1!=null){
                ListNode node=result;
                while (node.next!=null){
                    node=node.next;
                }
                node.next=new ListNode(list1.val);
                list1=list1.next;
            }
        }
        return result.next;
    }
}
