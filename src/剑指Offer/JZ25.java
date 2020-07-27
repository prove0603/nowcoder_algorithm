package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/27 9:10
 */

/*
    题目描述
        输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
        请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

 */
public class JZ25 {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode current=pHead;
//        复制链表  eg 复制A1 放到A的后面
        while (current!=null){
            RandomListNode tmp=current.next;
            RandomListNode copy=new RandomListNode(current.label);
            current.next=copy;
            copy.next=tmp;
            current=current.next.next;
        }
//        复制随机结点
        current=pHead;
        while (current!=null){
            RandomListNode copy=current.next;
            copy.random=current.random==null?null:current.random.next;
            current=current.next.next;
        }
//        这样写的话 原链表中会有结点指向新链表   导致系统判断出问题  (可通过debug查看内存地址得出)  所以得分离两个链表
//        current=pHead;
//        RandomListNode copyHead=current.next;
//        RandomListNode copyCurrent=copyHead;
//        while (copyCurrent.next!=null){
//            copyCurrent.next=copyCurrent.next.next;
//            copyCurrent=copyCurrent.next;
//        }


//        分离两个链表
        current=pHead;
        RandomListNode copyHead=current.next;
//        RandomListNode copyCurrent=copyHead;    这里不应该是 copyCurrent=copyHead;
        RandomListNode copyCurrent=current.next;
        while (current.next.next!=null){
            RandomListNode tmp=current.next.next;
            RandomListNode copyTmp=copyCurrent.next.next;
            current.next=tmp;
            copyCurrent.next=copyTmp;
            current=current.next;
            copyCurrent=copyCurrent.next;
        }
        current.next=null;
        return copyHead;
    }

    public static void main(String[] args) {
        RandomListNode a=new RandomListNode(1);
        RandomListNode b=new RandomListNode(2);
        RandomListNode c=new RandomListNode(3);
        a.next=b;b.next=c;
        a.random=c;b.random=a;
        c.random=b;
        JZ25 jz25=new JZ25();
        RandomListNode randomListNode=jz25.Clone(a);
        System.out.println(randomListNode.label);
        System.out.println(randomListNode.next.label);
        System.out.println(randomListNode.next.next.label);
    }
}
