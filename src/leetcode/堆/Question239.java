package leetcode.堆;

import java.util.*;

/**
 * @Date 2020/12/27 0:01
 * @Created by ZhuangJie
 * @Description
 * 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * priorityqueue默认是小顶堆
 */
public class Question239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        if (nums.length==0) return nums;
        int result[]=new int[nums.length-k+1];
        int index=0;
        for (int i = 0; i < nums.length ; i++) {
            if (deque.isEmpty()){
                deque.addLast(i);
            }else {
                if (i-k==deque.peekFirst()){
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.addLast(i);
            }
            if (i>=k-1){
                result[index]=nums[deque.peekFirst()];
                index++;
            }
        }
        return result;
    }

//    超出时间限制   因为remove也消耗不少时间  remove 是 O(k)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
//            return o2-o1;
//        }));
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i <k && i<nums.length; i++) {
//            priorityQueue.add(nums[i]);
//        }
//        if (k>=nums.length){
//            int[] res=new int[1];
//            res[0]=priorityQueue.peek();
//            return res;
//        }
//        arrayList.add(priorityQueue.peek());
//        for (int i = k; i < nums.length ; i++) {
//            priorityQueue.remove(nums[i-k]);
//            priorityQueue.add(nums[i]);
//            arrayList.add(priorityQueue.peek());
//        }
//        int[] result=new int[arrayList.size()];
//        for (int i = 0; i <arrayList.size() ; i++) {
//            result[i]=arrayList.get(i);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Question239 question239=new Question239();
        int arr[]={1,3,-1,-3,5,3,6,7};
        int tmp[]=question239.maxSlidingWindow(arr,3);
        System.out.println(123);
    }
}
