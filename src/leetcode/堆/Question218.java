package leetcode.堆;

import java.util.*;

/**
 * @Date 2020/12/20 22:40
 * @Created by ZhuangJie
 * @Description*
 * 天际线问题
 * https://leetcode-cn.com/problems/the-skyline-problem/
*/
public class Question218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<Node> arrayList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int[] building:buildings) {
            arrayList.add(new Node(building[0],building[2]));
            arrayList.add(new Node(building[1],-building[2]));
        }
        Collections.sort(arrayList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.index!=o2.index){
                    return o1.index-o2.index;
                }else {
                    return o2.height.compareTo(o1.height);
                }
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)->{
            return o2-o1;
        });
//        之前的最大值
        int pre=0;
        priorityQueue.add(0);
        for (Node node:arrayList) {
            if (node.height>0){
                priorityQueue.add(node.height);
            }else {
                priorityQueue.remove(-node.height);
            }
            if (priorityQueue.peek()!=pre){
                pre=priorityQueue.peek();
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(node.index);
                tmp.add(priorityQueue.peek());
                result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question218 question218 = new Question218();
//        int arr[][]={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int arr[][]={{2,9,100},{2,9,80},{2,9,70},{2,9,50}};
        List<List<Integer>> lists=question218.getSkyline(arr);
        System.out.println(123);

    }
    class Node{
        Integer index;
        Integer height;

        public Node(Integer index, Integer height) {
            this.index = index;
            this.height = height;
        }
    }
}
