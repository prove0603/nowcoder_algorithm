package leetcode.堆;

import java.util.*;

/**
 * @Date 2020/12/27 1:17
 * @Created by ZhuangJie
 * @Description
 *  会议室 II
 *  https://leetcode-cn.com/problems/meeting-rooms-ii/
 */
public class Question253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length==0) return 0;
        ArrayList<Node> list = new ArrayList<>();
        for (int[] arr:intervals) {
            list.add(new Node(arr[0],arr[1]));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.start!=o2.start){
                    return o1.start-o2.start;
                }else {
                    return o1.end-o2.end;
                }
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {return o1-o2;}));
        queue.add(0);
        for (Node node:list) {
            if (node.start>=queue.peek()){
                queue.poll();
                queue.add(node.end);
            }else {
                queue.add(node.end);
            }
        }
        return queue.size();
    }

    class Node{

        Integer start;
        Integer end;

        public Node(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }
}
