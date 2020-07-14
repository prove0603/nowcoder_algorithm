package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/14 10:34
 */
/*
    题目描述
        一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

 */
public class JZ09 {



//    方法一
//    public static int counter = 0;
//    public static void JumpFloorII(int target) {
//        if (target == 0) {
//            counter++;
//        }
//        for (int i = 1; i <= target; i++) {
//            if ((target - i) < 0) break;
//            JumpFloorII(target - i);
//        }
//    }


    //方法二
    public static int JumpFloorII(int target) {
        if (target==0) return 1;
        int counter=0;
        for (int i = 1; i <= target; i++) {
            if ((target - i) < 0) break;
            counter+=JumpFloorII(target - i);
        }
        return counter;
    }

/*
    方法三：
    链接：https://www.nowcoder.com/questionTerminal/22243d016f6b47f2a6928b4313c85387?f=discussion
来源：牛客网

    分析】 每个台阶可以看作一块木板，让青蛙跳上去，n个台阶就有n块木板，最后一块木板是青蛙到达的位子，
    必须存在，其他 (n-1) 块木板可以任意选择是否存在，则每个木板有存在和不存在两种选择，(n-1) 块木板
    就有 [2^(n-1)] 种跳法，可以直接得到结果。
    其实我们所要求的序列为：0,1,2,4,8,16,……
    所以除了第一位外，其他位的数都是前一位的数去乘以2所得到的积。
 */
    public static void main(String[] args) {
        System.out.println(JumpFloorII(5));
    }
}
