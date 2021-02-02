package leetcode.排序;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Date 2021/1/25 0:35
 * @Created by ZhuangJie
 * @Description
 * 插入区间
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class Question57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i <intervals.length ; i++) {
            list.add(new Node(intervals[i][0], intervals[i][1]));
        }
        list.add(new Node(newInterval[0],newInterval[1]));
        Collections.sort(list,(o1, o2)->{
            if (o1.start!= o2.start){
                return o1.start.compareTo(o2.start);
            }else {
                return o1.end.compareTo(o2.end);
            }
        });
        ArrayList<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i <list.size() ; i++) {
            if (!result.isEmpty() && list.get(i).start <= result.get(result.size()-1)[1]){
                if (list.get(i).end>result.get(result.size()-1)[1]){
                    int[] remove=result.remove(result.size()-1);
                    int tmp[]={remove[0],list.get(i).end};
                    result.add(tmp);
                }
            }else {
                int tmp[]={list.get(i).start,list.get(i).end};
                result.add(tmp);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    class Node{
        Integer start;
        Integer end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
