package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/20 17:44
 */
/*
    题目描述
        一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JZ08 {
    public static int JumpFloor(int target) {
        if (target==0) return 1;
        if (target<0) return 0;
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
}
