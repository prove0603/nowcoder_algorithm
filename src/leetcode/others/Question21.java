package leetcode.others;

/**
 * @Date 2021/2/4 0:41
 * @Created by ZhuangJie
 * @Description
 */
public class Question21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
//    两个指针太麻烦
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1==null || l2==null) {return l1==null?l2:l1;}
//        ListNode next1,next2,res1=l1,res2=l2;
//        while (l1!=null && l2!=null){
//            next1=l1.next;
//            next2=l2.next;
//            if (l1.val<= l2.val){
//                if(next1!=null){
//                    if(next1.val<=l2.val){
//                        l1=next1;
//                    }else{
//                        l1.next=l2;
//                        l1=next1;
//                    }
//                }else{
//                    l1.next=l2;
//                    break;
//                }
//            }else {
//                if(next2!=null){
//                    if(next2.val<l1.val){
//                        l2=next2;
//                    }else{
//                        l2.next=l1;
//                        l2=next2;
//                    }
//                }else{
//                    l2.next=l1;
//                    break;
//                }
//            }
//        }
//        if (res1.val<= res2.val){
//            return res1;
//        }else {
//            return res2;
//        }
//    }

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
