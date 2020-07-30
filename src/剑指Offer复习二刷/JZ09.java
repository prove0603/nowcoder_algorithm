package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 17:47
 */
    /*
        题目描述
            一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    */
public class JZ09 {
    public int JumpFloorII(int target) {
        if (target<=0) return 0;
        return (int)Math.pow(2,target-1);
    }
}
