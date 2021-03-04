package leetcode.others;

/**
 * @Date 2021/2/4 1:18
 * @Created by ZhuangJie
 * @Description
 */
public class Question26 {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) {return 0;}
        int p=0,q=1;
        while (q<nums.length){
            if (nums[p]!=nums[q]){
                nums[p+1]=nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}
