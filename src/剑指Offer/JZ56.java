package 剑指Offer;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/22 9:52
 */
    /*
        题目描述
            在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
            例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

    */
public class JZ56 {
    
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

//    哈希
//    public ListNode deleteDuplication(ListNode pHead) {
//        if (pHead==null) return pHead;
//        HashSet<Integer> totalSet=new HashSet<>();
//        HashSet<Integer> repeatSet=new HashSet<>();
//        ListNode tmpNode=pHead;
//        while (tmpNode!=null){
//            int size=totalSet.size();
//            totalSet.add(tmpNode.val);
//            if (totalSet.size()==size){
//                repeatSet.add(tmpNode.val);
//            }
//            tmpNode=tmpNode.next;
//        }
//        ListNode tmpNode2=pHead;
//        ArrayList<ListNode> arrayList=new ArrayList<>();
//        while (tmpNode2!=null){
//            if (!repeatSet.contains(tmpNode2.val)){
//                arrayList.add(tmpNode2);
//            }
//            tmpNode2=tmpNode2.next;
//        }
//        ListNode head=null;
//        for (int i = 0; i <arrayList.size() ; i++) {
//            ListNode n=new ListNode(arrayList.get(i).val);
//            ListNode p=head;
//            if (head==null){
//                head=n;
//            }else {
////                这样是不行的
////                while (p!=null){
////                    p=p.next;
////                }
////                p=n;
//                while (p.next!=null){
//                    p=p.next;
//                }
//                p.next=n;
//            }
//        }
//        return head;
//    }


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null ||pHead.next==null) return pHead;
//        为了解决第一个  第二个就相同的情况
        ListNode Head=new ListNode(-1);
        ListNode first=Head;
        ListNode second=pHead;
        while (second!=null){
            if (second.next!=null && second.val==second.next.val){
                // 找到最后的一个相同节点
                while (second.next!=null &&second.val==second.next.val){
                    second=second.next;
                }
                second=second.next;
//                防止最后几个是相同的；
                if(second==null){
                    first.next=second;
                }
            }else {
                first.next=second;
                first=second;
                second=second.next;
            }
        }
        return Head.next;
    }


    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(3);
        ListNode e=new ListNode(4);
        ListNode f=new ListNode(4);
        ListNode g=new ListNode(5);
        a.next=b;b.next=c;c.next=d;d.next=e;e.next=f;f.next=g;

        JZ56 jz56=new JZ56();
        ListNode result=jz56.deleteDuplication(a);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }
}
