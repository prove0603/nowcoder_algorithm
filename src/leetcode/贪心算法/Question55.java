package leetcode.贪心算法;

/**
 * @Date 2021/1/26 23:57
 * @Created by ZhuangJie
 * @Description
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Question55 {
    public boolean canJump(int[] nums) {
        int len= nums.length;
        if (len==1 ){return true;}
        int start=nums[0];
        if (start==0) {return false;}
        int max=start;
        for (int i = 1; i <len ; ) {
            int tmp=i;
            int newMax=0;
            while (tmp<=max){
                newMax=Math.max(newMax,tmp+nums[tmp]);
                if (tmp==max && max==newMax){
                    return false;
                }
            }
            max=newMax;
        }
        return true;
    }
}
