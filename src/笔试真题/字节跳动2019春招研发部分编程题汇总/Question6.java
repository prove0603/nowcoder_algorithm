package 笔试真题.字节跳动2019春招研发部分编程题汇总;

import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/14 16:31
 */

/*

     Z国的货币系统包含面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
     现在小Y使用1024元的纸币购买了一件价值为的商品，请问最少他会收到多少硬币？

        输入描述:

        一行，包含一个数N。


        输出描述:

        一行，包含一个数，表示最少收到的硬币数。


        输入例子1:

        200


        输出例子1:

        17


        例子说明1:

        花200，需要找零824块，找12个64元硬币，3个16元硬币，2个4元硬币即可。


 */

public class Question6 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int target=1024-n;
        if (target==0) {
            System.out.println(0);
            return;
        }
        int counter=0;
        int tmp64=target/64;
        counter+=tmp64;
        target=target-tmp64*64;
        int tmp16=target/16;
        counter+=tmp16;
        target=target-tmp16*16;
        int tmp4=target/4;
        counter+=tmp4;
        target=target-tmp4*4;
        int tmp1=target/1;
        counter+=tmp1;
        System.out.println(counter);
    }

//    public static int f(int coins[],int target){
//
//    }
}
