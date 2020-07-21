package 剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/21 14:19
 */
    /*
        题目描述
            给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
            例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
            那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
            针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
            {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
            {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
    */
public class JZ64 {

    //普通方法
//    public ArrayList<Integer> maxInWindows(int [] num, int size) {
//        if (size==0) return new ArrayList<>();
//        ArrayList<ArrayList<Integer>> totalList=new ArrayList<>();
//        for (int i = 0; i <=num.length-size ; i++) {
//            ArrayList<Integer> tmp=new ArrayList<>();
//            for (int j = 0; j <size ; j++) {
//                tmp.add(num[i+j]);
//            }
//            totalList.add(tmp);
//        }
//        ArrayList<Integer> result=new ArrayList<>();
//        for (int i = 0; i <totalList.size() ; i++) {
//            int max=Integer.MIN_VALUE;
//            for (int j = 0; j <totalList.get(i).size() ; j++) {
//                if (totalList.get(i).get(j)>max) max=totalList.get(i).get(j);
//            }
//            result.add(max);
//        }
//        return result;
//    }

//    优先队列法  减少了第二次排序的时间 效率n*k
//    public ArrayList<Integer> maxInWindows(int [] num, int size) {
//        ArrayList<Integer> result=new ArrayList<>();
//        if (size==0) return result;
//        PriorityQueue<Integer> queue=new PriorityQueue<>(size, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        for (int i = 0; i <=num.length-size ; i++) {
//            int count=0;
//            while (count<size){
//                queue.add(num[i+count]);
//                count++;
//            }
//            result.add(queue.peek());
//            queue.clear();
//        }
//        return result;
//    }


//    双向队列 ArrayDeque
//    1.通过加入下标而不是数字本身   去判断最大数字是否已经过期
//    2.通过  从队尾开始扫描   小于新加入数字的元素全部弹出  去实现队首是最大
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (size==0) return arrayList;
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        for (int i = 0; i <num.length ; i++) {
            int begin=i-size+1;
            if (arrayDeque.isEmpty()){
                arrayDeque.add(i);
            }
            if (begin>arrayDeque.peekFirst()){
                arrayDeque.pollFirst();  //窗口移动  该数字已经失效了
            }
            while (!arrayDeque.isEmpty() && (num[arrayDeque.peekLast()]<=num[i])){
                arrayDeque.pollLast();
            }
            arrayDeque.add(i);
            if (begin>=0){
                arrayList.add(num[arrayDeque.peekFirst()]);
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        JZ64 jz64=new JZ64();
        ArrayList<Integer> a=jz64.maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
//        for (int i = 0; i <a.size(); i++) {
//            System.out.print(a.get(i)+" ");
//        }
    }
}
