package 笔试真题.字节跳动2019春招研发部分编程题汇总;

import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/14 11:02
 */
/*
        我叫王大锤，是一名特工。我刚刚接到任务：在字节跳动大街进行埋伏，抓捕恐怖分子孔连顺。
        和我一起行动的还有另外两名特工，我提议

        1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
        2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。

        我特喵是个天才! 经过精密的计算，我们从X种可行的埋伏方案中选择了一种。这个方案万无一失，颤抖吧，孔连顺！
        ……
        万万没想到，计划还是失败了，孔连顺化妆成小龙女，混在cosplay的队伍中逃出了字节跳动大街。只怪他的伪装太成功了，就是杨过本人来了也发现不了的！

        请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，
        计算在这次行动中，大锤的小队有多少种埋伏选择。
        注意：
        1. 两个特工不能埋伏在同一地点
        2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用


        输入描述:

        第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)

        第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）


        输出描述:

        一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模


        输入例子1:

        4 3
        1 2 3 4


        输出例子1:

        4


        例子说明1:

        可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)

        输入例子2:

        5 19
        1 10 20 30 50

        输出例子2:

        1

        例子说明2:

        可选方案 (1, 10, 20)

 */
public class Question2 {

//    思路  以右端点为判断  符合条件的进行c 几 2计算(因为包含了右端点  所以剩下两个)  这样能保证不重复
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int d=in.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=in.nextInt();
        }
        long counter=0;
        int left=0,right=2;
        while (right<n){
            if (arr[right]-arr[left]>d){
                left++;
            }else if (right-left<2){
                right++;
            }else {
                counter+=cal(right-left);
                right++;
            }
        }
        counter=counter%99997867;
        System.out.println(counter);
    }

//    计算c 几 2
    public static long cal(long number){
        return number*(number-1)/2;
    }
//    多次遍历效率太低   就算剪枝了效率还是低
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int d=in.nextInt();
//        int arr[]=new int[n];
//        for (int i = 0; i <n ; i++) {
//            arr[i]=in.nextInt();
//        }
//        int counter=0;
//        for (int i = 0; i <n ; i++) {
//            int j=n-1;
//            for (j = n-1; j >=i+2 ; j--) {
//                if (arr[j]-arr[i]<=d) break;
//            }
//            counter=(counter+count(j,3))%99997867;
//        }
//        System.out.println(counter);
//
//    }
//
//    public static int count(int a,int b){
//        int counterA=1,counterB=1,counterC=1,c=a-b;
//        while (a!=0){
//            counterA=counterA*a;
//            a--;
//        }
//        while (b!=0){
//            counterB=counterB*b;
//            b--;
//        }
//        while (c!=0){
//            counterC=counterC*c;
//            c--;
//        }
//        return counterA/(counterB*counterC);
//    }
}
