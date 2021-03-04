package leetcode.others;

/**
 * @Date 2021/2/10 0:38
 * @Created by ZhuangJie
 * @Description
 */
public class Question35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0) {return 0;}
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]>=target) {return i;}
        }
        return nums.length;
    }
}
