package leetcode.others;

/**
 * @Date 2021/2/6 1:48
 * @Created by ZhuangJie
 * @Description
 */
public class Question136 {
    public int singleNumber(int[] nums) {
        if (nums.length==1) {return nums[0];}
        for (int i = 1; i <nums.length ; i++) {
            nums[i]=nums[i-1]^nums[i];
        }
        return nums[nums.length-1];
    }
}
