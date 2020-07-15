package 剑指Offer;

import java.util.HashSet;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/15 9:19
 */

/*
    题目描述
        给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

public class JZ55 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

//    hashset法
//    public ListNode EntryNodeOfLoop(ListNode pHead) {
//        HashSet<ListNode> set=new HashSet<>();
//        set.add(pHead);
//        int size=set.size();
//        while (pHead.next!=null){
//            set.add(pHead.next);
//            if (size==set.size()){
//                return pHead.next;
//            }
//            size=set.size();
//            pHead=pHead.next;
//        }
//        return null;
//    }

//    快慢指针法  https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?f=discussion
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast=pHead;
        ListNode slow=pHead;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){  //相遇
                break;
            }
        }
//        说明没有环
        if (fast==null || fast.next==null){
            return null;
        }
        slow=pHead;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
