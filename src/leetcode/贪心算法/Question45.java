package leetcode.贪心算法;

/**
 * @Date 2021/1/26 22:56
 * @Created by ZhuangJie
 * @Description
 * 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 * https://leetcode-cn.com/problems/jump-game-ii/solution/45-by-ikaruga/
 */
public class Question45 {
    public int jump(int[] nums) {
        int len= nums.length;
        if (len==1){return 0;}
        int counter=1;
        int max=nums[0];
        if(nums[0]>=len-1){return 1;}
        for (int i = 1; i <len ;) {
            int tmp=i;
            int newMax=0;
            while (tmp<=max){
                newMax=Math.max(newMax,tmp+nums[tmp]);
                tmp++;
            }
            counter++;
            if (newMax>=len-1){
                return counter;
            }else {
                i=max+1;
                max=newMax;
            }
        }
        return counter;
    }
}
