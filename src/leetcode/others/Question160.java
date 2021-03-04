package leetcode.others;

/**
 * @Date 2021/2/18 1:36
 * @Created by ZhuangJie
 * @Description
 */
public class Question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) {return null;}
        ListNode tmpa=headA,tmpb=headB;
        int lengtha=0,lengthb=0;
        while (tmpa!=null){
            tmpa=tmpa.next;
            lengtha++;
        }
        while (tmpb!=null){
            tmpb=tmpb.next;
            lengthb++;
        }
        if (lengtha>=lengthb){
            int tmp=lengtha-lengthb;
            while (tmp!=0){
                headA=headA.next;
                tmp--;
            }
        }else{
            int tmp=lengthb-lengtha;
            while (tmp!=0){
                headB=headB.next;
                tmp--;
            }
        }
        while (headA!=null && headB!=null){
            if (headA==headB){return headA;}
            else {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
