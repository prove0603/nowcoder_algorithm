package 笔试真题.字节跳动2019春招研发部分编程题汇总;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/14 14:14
 */
/*
        小包最近迷上了一款叫做雀魂的麻将游戏，但是这个游戏规则太复杂，小包玩了几个月了还是输多赢少。
        于是生气的小包根据游戏简化了一下规则发明了一种新的麻将，只留下一种花色，
        并且去除了一些特殊和牌方式（例如七对子等），具体的规则如下：

            总共有36张牌，每张牌是1~9。每个数字4张牌。
            你手里有其中的14张牌，如果这14张牌满足如下条件，即算作和牌

            14张牌中有2张相同数字的牌，称为雀头。
            除去上述2张牌，剩下12张牌可以组成4个顺子或刻子。顺子的意思是递增的连续3个数字牌（例如234,567等），
            刻子的意思是相同数字的3个数字牌（例如111,777）


        例如：
        1 1 1 2 2 2 6 6 6 7 7 7 9 9 可以组成1,2,6,7的4个刻子和9的雀头，可以和牌
        1 1 1 1 2 2 3 3 5 6 7 7 8 9 用1做雀头，组123,123,567,789的四个顺子，可以和牌
        1 1 1 2 2 2 3 3 3 5 6 7 7 9 无论用1 2 3 7哪个做雀头，都无法组成和牌的条件。

        现在，小包从36张牌中抽取了13张牌，他想知道在剩下的23张牌中，再取一张牌，取到哪几种数字牌可以和牌。

        输入描述:

        输入只有一行，包含13个数字，用空格分隔，每个数字在1~9之间，数据保证同种数字最多出现4次。


        输出描述:

        输出同样是一行，包含1个或以上的数字。代表他再取到哪些牌可以和牌。若满足条件的有多种牌，请按从小到大的顺序输出。若没有满足条件的牌，请输出一个数字0


        输入例子1:

        1 1 1 2 2 2 5 5 5 6 6 6 9


        输出例子1:

        9


        例子说明1:

        可以组成1,2,6,7的4个刻子和9的雀头


        输入例子2:

        1 1 1 1 2 2 3 3 5 6 7 8 9


        输出例子2:

        4 7


        例子说明2:

        用1做雀头，组123,123,567或456,789的四个顺子


        输入例子3:

        1 1 1 2 2 2 3 3 3 5 7 7 9


        输出例子3:

        0


        例子说明3:

        来任何牌都无法和牌

        https://www.nowcoder.com/test/question/done?tid=36058204&qid=362292#summary
 */
public class Question3 {

//    直接通过每种数字的个数判断 而不是靠具体的数字排列判断  要注意好回溯
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int arr[]=new int[13];
        int count[]=new int[10];
        for (int i = 0; i < 13; i++) {
            arr[i]=in.nextInt();
            count[arr[i]]++;
        }
        boolean success=false;
        for (int i = 1; i <=9 ; i++) {
            if (count[i]<4){
                count[i]++;
                boolean flag=hupai(count);
                count[i]--;
                if (flag){
                    System.out.print(i+" ");
                    success=true;
                }
            }
        }
        if (!success){
            System.out.println(0);
        }
    }

    public static boolean hupai(int count[]){
        //两张一样的牌凑成雀头
        boolean flag=false;//判断能否胡牌
        for (int i = 1; i <=9 ; i++) {
            if (count[i]>=2){
                count[i]-=2;
//               剩下的牌能否凑成三张一样的或者是顺子
                flag=f(count,4);
                count[i]+=2;
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean f(int count[],int n){
        if (n==0) return true;
        for (int i = 1; i <=9 ; i++) {
            if (count[i]>=3){
                count[i]-=3;
                boolean flag333= f(count,n-1);
                count[i]+=3;
                if (flag333){
                    return true;
                }
            }
            if (i<=7 && count[i]>0 && count[i+1]>0 && count[i+2]>0){
                count[i]--;count[i+1]--;count[i+2]--;
                boolean flag123= f(count,n-1);
                count[i]++;count[i+1]++;count[i+2]++;
                if (flag123){
                    return true;
                }
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Integer arr[] = new Integer[14];
//        for (int i = 0; i < 13; i++) {
//            arr[i] = in.nextInt();
//        }
//        int sout = 0;
//        for (int i = 1; i < 10; i++) {
//            arr[13] = i;
//            if (hupai(arr) == true) {
//                sout = 1;
//                System.out.print(i + " ");
//                flag = 0;
//            }
//        }
//        if (sout == 0) System.out.println(0);
////        Integer arr1[]={1,1,1,2,2,2,5,5,5,6,6,6,9,9};
////        Integer arr1[]={1,1,1,1,2,2,3,3,5,6,7,7,8,9};
//
//    }
//
//    public static int flag = 0;
//
//    public static void f(ArrayList<Integer> tmpList, int j) {
//        if (j == 12) {
//            flag = 1;
//            return;
//        }
//        //三个一样的
//        if (j + 2 < 12 && (tmpList.get(j) == tmpList.get(j + 1)) && (tmpList.get(j + 1) == tmpList.get(j + 2))) {
//            f(tmpList, j + 3);
//        }
//        //三个连续的
//        if (j + 2 < 12 && (tmpList.get(j) == tmpList.get(j + 1) - 1) && (tmpList.get(j + 1) == tmpList.get(j + 2) - 1)) {
//            f(tmpList, j + 3);
//        }
//        //三个连续的对子
//        if (j + 5 < 12 && (tmpList.get(j) == tmpList.get(j + 1)) && (tmpList.get(j + 2) == tmpList.get(j + 3))
//                && (tmpList.get(j + 4) == tmpList.get(j + 5)) && (tmpList.get(j) == tmpList.get(j + 1) - 1) && (tmpList.get(j + 1) == tmpList.get(j + 2) - 1)) {
//            f(tmpList, j + 6);
//        }
//    }
//
//    public static boolean hupai(Integer arr[]) {
//        Integer tmp[] = arr.clone();
//        //排序
//        Arrays.sort(tmp);
//        //找对子
//        for (int i = 0; i < tmp.length - 1; i++) {
//            if (tmp[i] == tmp[i + 1]) {
//                ArrayList<Integer> tmpList = new ArrayList<Integer>(Arrays.asList(tmp));
//                tmpList.remove(i);
//                tmpList.remove(i);
//                f(tmpList, 0);
//                tmpList = new ArrayList<Integer>(Arrays.asList(tmp));
//                if (flag == 1) return true;
//            }
//        }
//        return false;
//    }
}
