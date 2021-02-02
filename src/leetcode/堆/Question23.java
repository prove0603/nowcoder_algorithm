package leetcode.堆;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Date 2020/12/18 2:40
 * @Created by ZhuangJie
 * @Description 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 整理笔记  头插法  尾插法
 */
public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (ListNode node:lists) {
            while (node !=null){
                arrayList.add(node.val);
                node=node.next;
            }
        }

        Collections.sort(arrayList,Collections.reverseOrder());
        ListNode node = null;
        for (Integer e : arrayList) {
            ListNode head = new ListNode(e);
            head.next=node;
            node=head;
        }
        return node;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
//        尾插法
//        ListNode node=new ListNode(0);
//        for (Integer e:arrayList) {
//            ListNode tail=node;
//            while (tail.next!=null) {
//                tail=tail.next;
//            }
//            tail.next=new ListNode(e);
//        }
        ListNode node = new ListNode(0);
        for (Integer e : arrayList) {
            ListNode head = new ListNode(e);
            head.next=node;
            node=head;
        }
    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * <p>
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：lists = [[]]
     * 输出：[]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class ListNode {
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
