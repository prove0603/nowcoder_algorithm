package leetcode.others;

/**
 * @Date 2021/2/11 16:18
 * @Created by ZhuangJie
 * @Description
 */
public class Question83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){return null;}
        ListNode result=head,next;
        while (head!=null){
            next=head.next;
            if (next==null) {break;}
            while (head.val==next.val){
                next=next.next;
                if (next==null) {break;}
            }
            head.next=next;
            head=next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
