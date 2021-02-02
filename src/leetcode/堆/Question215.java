package leetcode.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Date 2020/12/18 3:39
 * @Created by ZhuangJie
 * @Description
 * 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Question215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length==0) return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return -1;
                else if(o1<o2) return 1;
                else return 0;
            }
        });
        for (Integer i:nums) {
            priorityQueue.offer(i);
        }
        for (int i = 1; i <k ; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return -1;
                else if(o1<o2) return 1;
                else return 0;
            }
        });
        priorityQueue.add(5);
        priorityQueue.add(9);
        priorityQueue.add(1);
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
    }
    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
