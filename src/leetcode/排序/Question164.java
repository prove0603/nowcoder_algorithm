package leetcode.排序;

import java.util.Arrays;

/**
 * @Date 2021/1/25 18:52
 * @Created by ZhuangJie
 * @Description
 * 最大间距
 * https://leetcode-cn.com/problems/maximum-gap/
 */
public class Question164 {
    /**
        用基数排序的方式
     */
    public int maximumGap(int[] nums) {
        int len= nums.length;
        if (len<2){return 0;}
        int newArray[]=new int[len];
        int max = Arrays.stream(nums).max().getAsInt();
        int rep=1;
        while (max/rep !=0){
            int backet[]=new int[10];
            for (int i = 0; i <len ; i++) {
                int digit=(nums[i]/rep)%10;
                backet[digit]++;
            }
            for (int i = 1; i <10 ; i++) {
                backet[i]+=backet[i-1];
            }
            //从后往前 而不是从前往后的原因是  从第二轮开始时  要让大的先落位   测试用例：[6,9,11,3,13,1]
            // 如果是从前往后   跑第二轮  [1,11,13,3,6,9]   1会先落位
            for (int i = len-1; i >=0 ; i--) {
                int digit=(nums[i]/rep)%10;
                newArray[backet[digit]-1]=nums[i];
                backet[digit]--;
            }
            rep*=10;
            System.arraycopy(newArray, 0, nums, 0, len);
        }
        int gap=0;
        for (int i = 0; i <nums.length-1 ; i++) {
            gap=Math.max(gap,nums[i+1]-nums[i]);
        }
        return gap;
    }
}
