package leetcode.排序;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Date 2021/1/25 15:38
 * @Created by ZhuangJie
 * @Description 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class Question147 {

    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) {return head;}
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        ListNode newNode=new ListNode(list.get(list.size()-1));
        for (int i = list.size()-2; i >=0 ; i--) {
            ListNode tmp=new ListNode(list.get(i));
            tmp.next=newNode;
            newNode=tmp;
        }
        return newNode;
    }

    /**
     * class Solution {
     *     public ListNode insertionSortList(ListNode head) {
     *         if (head == null) {
     *             return head;
     *         }
     *         ListNode dummyHead = new ListNode(0);
     *         dummyHead.next = head;
     *         ListNode lastSorted = head, curr = head.next;
     *         while (curr != null) {
     *             if (lastSorted.val <= curr.val) {
     *                 lastSorted = lastSorted.next;
     *             } else {
     *                 ListNode prev = dummyHead;
     *                 while (prev.next.val <= curr.val) {
     *                     prev = prev.next;
     *                 }
     *                 lastSorted.next = curr.next;
     *                 curr.next = prev.next;
     *                 prev.next = curr;
     *             }
     *             curr = lastSorted.next;
     *         }
     *         return dummyHead.next;
     *     }
     * }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/dui-lian-biao-jin-xing-cha-ru-pai-xu-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
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
