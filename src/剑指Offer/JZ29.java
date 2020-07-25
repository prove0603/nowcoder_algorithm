package 剑指Offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/25 16:24
 */

/*
    题目描述
        输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

 */
public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if (k>input.length) return list;
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i <input.length ; i++) {
            queue.add(input[i]);
        }
        for (int i = 0; i <(k>input.length?input.length:k) ; i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
