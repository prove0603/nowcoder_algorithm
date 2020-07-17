package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/17 11:33
 */

/*
        题目描述
            输入两个链表，找出它们的第一个公共结点。
            （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
            https://www.nowcoder.com/questionTerminal/6ab1d9a29e88450685099d45c9e31e46?f=discussion
 */
public class JZ36 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null || pHead2==null) return null;
        int lena=1,lenb=1;
        ListNode tmp1=pHead1;
        ListNode tmp2=pHead2;
        while (tmp1.next!=null) {
            lena++;
            tmp1=tmp1.next;
        }
        while (tmp2.next!=null) {
            lenb++;
            tmp2=tmp2.next;
        }
        int counter=lena-lenb;
        if (counter>0){
            while (counter>0){
                pHead1=pHead1.next;
                counter--;
            }
        }else if (counter<0){
            counter=-counter;
            while (counter>0){
                pHead2=pHead2.next;
                counter--;
            }
        }
        while (pHead1!=null){
            if (pHead1 .equals(pHead2) ){
                return pHead1;
            }else {
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        JZ36 jz36=new JZ36();
        ListNode one=new ListNode(1);
        ListNode two=new ListNode(2);
        ListNode three=new ListNode(3);
        one.next=two;
        two.next=three;
        System.out.println(jz36.FindFirstCommonNode(one,two));
    }
}
