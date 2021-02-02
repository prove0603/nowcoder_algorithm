package leetcode.栈;

import java.util.ArrayDeque;

/**
 * @Date 2020/12/10 23:20
 * @Created by ZhuangJie
 * @Description
 * 接雨水
 */
public class Question42 {

        public int trap(int[] height) {
            int len=height.length;
            if (len==0) {return 0;}
            int res=0;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i <height.length ; i++) {
                while (!stack.isEmpty() && height[i]>height[stack.peekLast()]){
                    int curHeight=height[stack.pollLast()];
                    if(stack.isEmpty()) {break;}
                    int width=i-stack.peekLast()-1;
                    res+=width*(Math.min(height[i],height[stack.peekLast()])-curHeight);
                }
                stack.addLast(i);
            }
            return res;
        }

    public static void main(String[] args) {
        Question42 question42 = new Question42();
        int arr[]={4,2,0,3,2,5};
        System.out.println(question42.trap(arr));
    }
    /*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 

示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}
