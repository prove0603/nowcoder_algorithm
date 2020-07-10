package 剑指Offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/10 16:48
 *
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&&tqId=11216&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */


//    找中位数就要从大的数里面找最小的   从小的数里面找最大的   所以可以用大顶堆与小顶堆
//    把大顶堆最大的数放一边   小顶堆中最小的数放另一边   就能实现  一边大   一边小
//    用链表也行
public class JZ63 {

//    小顶堆
    public PriorityQueue<Integer> smallHeap=new PriorityQueue<>();
//    大顶堆
    public PriorityQueue<Integer> bigHeap=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public static int count=0;

    public void Insert(Integer num) {
//        偶数个
        if (count%2==0){
            smallHeap.offer(num);
            bigHeap.offer(smallHeap.poll());
            count++;
        }else {
            bigHeap.offer(num);
            smallHeap.offer(bigHeap.poll());
            count++;
        }
    }

    public Double GetMedian() {
        if (count==0) return 0.0;
        if (count%2==1){
            return new Double(bigHeap.peek());
        }else {
            return new Double(bigHeap.peek()+smallHeap.peek())/2;
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        JZ63 jz63=new JZ63();
        while (in.hasNext()){
            jz63.Insert(in.nextInt());
            System.out.println(jz63.GetMedian());
        }
    }
}


/*
import java.util.LinkedList;

public class Solution {

    LinkedList<Integer> list = new LinkedList<Integer>();

    public void Insert(Integer num) {
        if (list.size()==0||num < list.getFirst()) {
            list.addFirst(num);
        } else {
            boolean insertFlag = false;
            for (Integer e : list) {
                if (num < e) {
                    int index = list.indexOf(e);
                    list.add(index, num);
                    insertFlag = true;
                    break;
                }
            }
            if (!insertFlag) {
                list.addLast(num);
            }
        }

    }

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }

        if (list.size() % 2 == 0) {
            int i = list.size() / 2;
            Double a = Double.valueOf(list.get(i - 1) + list.get(i));
            return a / 2;
        }
        list.get(0);
        Double b = Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));

    }

}
 */