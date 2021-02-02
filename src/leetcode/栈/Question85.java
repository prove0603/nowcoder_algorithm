package leetcode.栈;

import java.util.ArrayDeque;

/**
 * @Date 2020/12/12 1:18
 * @Created by ZhuangJie
 * @Description
 * 最大矩形
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class Question85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        int[] heights=new int[matrix[0].length];
        int maxArea=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j]=='1'){
                    heights[j]++;
                }else {
                    heights[j]=0;
                }
            }
            maxArea=Math.max(maxArea,helper(heights));
        }
        return maxArea;
    }

    //使用第八十四题的方法
    public int helper(int heights[]){
        int len=heights.length;
        if (len==0) return 0;
        if (len==1) return heights[0];
        int newHeights[]=new int[len+2];
        newHeights[0]=0;
        System.arraycopy(heights,0,newHeights,1,len);
        newHeights[len+1]=0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int max=0;
        for (int i = 1; i < newHeights.length ; i++) {
            while (newHeights[i]<newHeights[stack.peekLast()]){
                int curHeight=newHeights[stack.pollLast()];
                int leftIndex=stack.peekLast();
                max=Math.max(max,(i-leftIndex-1)*curHeight);
            }
            stack.addLast(i);
        }
        return max;
    }

    public static void main(String[] args) {
        Question85 question85 = new Question85();
        char heights[][]={{'0','1'},{'1','0'}};
        System.out.println(question85.maximalRectangle(heights));
    }
}
