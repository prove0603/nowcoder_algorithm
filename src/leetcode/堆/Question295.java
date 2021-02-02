package leetcode.堆;

import java.util.PriorityQueue;

/**
 * @Date 2020/12/29 0:54
 * @Created by ZhuangJie
 * @Description
 * 数据流的中位数
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 */
public class Question295 {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int counter=0;

    public Question295() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(((o1, o2) -> {return  o2-o1;}));
    }

    public void addNum(int num) {
        counter++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
//        奇数个数字
        if ((counter & 1)==1){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((counter & 1)==1){
            return maxHeap.peek();
        }else {
            return ((double)maxHeap.peek()+minHeap.peek())/2;
        }
    }
}
