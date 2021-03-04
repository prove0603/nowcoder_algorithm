package leetcode.others;

/**
 * @Date 2021/2/6 1:43
 * @Created by ZhuangJie
 * @Description
 */
public class Question141 {
    public boolean hasCycle(ListNode head) {
        if (head==null) {return false;}
        if (head.next==null) {return false;}
        ListNode slow=head;
        ListNode quick=head;
        while (slow!=null && quick!=null){
            slow=slow.next;
            quick=quick.next;
            if (quick==null) {return false;}
            quick=quick.next;
            if (slow==quick) {return true;}
        }
        return false;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
