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
//  时间复杂都为2*N
//    public ListNode FindKthToTail(ListNode head,int k) {
//        if (k<=0) return null;
//        int length=0;
//        ListNode tmp=head;
//        while (tmp!=null){
//            length++;
//            tmp=tmp.next;
//        }
//        if (k>length) return null;
//        int target=length-k+1;
//        int counter=0;
//        while (head!=null){
//            counter++;
//            if (counter==target) return head;
//            head=head.next;
//        }
//        return null;
//    }

//    时间复杂度为 N
//    思路：倒数第k的节点  就是离最后null结点距离为k的节点
//    eg: 1 2 3 4 5 null   倒数第4个节点就是2  2+4=null
//    代码可以简化  让快指针先走k步  然后快慢指针一起走
    /*
        class Solution {
        public:
            ListNode* FindKthToTail(ListNode* pListHead, unsigned int k) {
                if (!pListHead || k <= 0) return nullptr;
                auto slow = pListHead, fast = pListHead;

                while (k--) {
                    if (fast)
                        fast = fast->next;
                    else
                        return nullptr; //如果单链表长度 < K,直接返回
                }
                while (fast) {
                    slow = slow->next;
                    fast = fast->next;
                }
                return slow;
            }
        };
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (k<=0) return null;
        while (head!=null){
            int counter=k;
            ListNode tmp=head;
            while (counter>0){
                tmp=tmp.next;
                counter--;
                if (tmp==null && counter!=0) //说明k大于链表的长度
                    return null;
            }
            if (tmp==null) return head;
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
        System.out.println(jz14.FindKthToTail(a,0).val);
    }
}
