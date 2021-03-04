package 笔试真题.顺丰科技汇总;

import java.util.HashMap;

/**
 * @Date 2021/3/4 22:08
 * @Created by ZhuangJie
 * @Description
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],i );
        }
        for (int i = 0; i < nums.length ; i++) {
            int tmp=target-nums[i];
            if (map.get(tmp)!=null && map.get(tmp)!=i){
                res[0]=map.get(tmp);
                res[1]=i;
            }
        }
        return res;
    }
}
