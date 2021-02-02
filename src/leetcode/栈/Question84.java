package leetcode.栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Date 2020/12/10 21:19
 * @Created by ZhuangJie
 * @Description
 * 使用动态规划，矩形的高取选中矩形中的最小值，矩形的底为选中矩形的个数
 * 如果有矩形高度为0  则要重新计算
 */
public class Question84 {

    public int largestRectangleArea(int[] heights) {
        int len= heights.length;
        if (len==0) {return 0;}
        if (len==1) {return heights[0];}
        int[] newHeights=new int[len+2];
        newHeights[0]=0;
        System.arraycopy(heights,0,newHeights,1,len);
        newHeights[newHeights.length-1]=0;
        len+=2;
        Deque<Integer> stack=new ArrayDeque<>();
        //加入一个哨兵   这样就可以减少空判断的代码
        stack.addLast(0);
        int max=0;
        for (int i = 1; i <newHeights.length ; i++) {
            while (newHeights[i]<newHeights[stack.peekLast()]){
                int height=newHeights[stack.pollLast()];
                int leftIndex=stack.peekLast();
                max=Math.max(max,(i-leftIndex-1)*height);
            }
            stack.addLast(i);
        }
        return max;
    }

    public static void main(String[] args) {
        Question84 q=new Question84();
        int[] arr={0,9};
        System.out.println(q.largestRectangleArea(arr));
    }
    /*
    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

 



以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

 



图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

 

示例:

输入: [2,1,5,6,2,3]
输出: 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
