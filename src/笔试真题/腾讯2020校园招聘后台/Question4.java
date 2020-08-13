package 笔试真题.腾讯2020校园招聘后台;

import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/13 14:00
 */

/*
         由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。
         他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，
         小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。

        输入描述:

        第一行一个整数  表示放假天数
        第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
        第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
        （1为营业 0为不营业）


        输出描述:

        一个整数，表示小Q休息的最少天数


        输入例子1:

        4
        1 1 0 0
        0 1 1 0


        输出例子1:

        2


        例子说明1:

        小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天

 */
public class Question4 {

//    使用动态规划
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int company[] = new int[n+1];
        int gym[] = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            company[i]=in.nextInt();
        }
        for (int i = 1; i <=n ; i++) {
            gym[i]=in.nextInt();
        }

//      dp[][0]代表休息  dp[][1]代表上班  dp[][2]代表健身
//      如果第i天是休息的话   那不休息天数的最大值等于 Max(dp[i-1][0] dp[i-1][1] dp[i-1][2])
//      如果第i天是工作的话   那不休息天数的最大值等于 Max(dp[i-1][0] dp[i-1][2]) 因为不能连续工作或者健身
//      如果第i天是健身的话   那不休息天数的最大值等于 Max(dp[i-1][0] dp[i-1][1])
        int dp[][]=new int[n+1][3];
        for (int i = 1; i <n+1 ; i++) {
            if (company[i]==1){
//             第i天可以选择工作
                dp[i][1]=Math.max(dp[i-1][0],dp[i-1][2])+1;
            }
            if (gym[i]==1){
//             第i天可以选择健身
                dp[i][2]=Math.max(dp[i-1][0],dp[i-1][1])+1;
            }
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
        }
        System.out.println(n-Math.max(dp[n][0],Math.max(dp[n][1],dp[n][2])));
    }


//    暴力解法  时间复杂度过高
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int company[] = new int[n+1];
//        int gym[] = new int[n+1];
//        for (int i = 1; i <=n ; i++) {
//            company[i]=in.nextInt();
//        }
//        for (int i = 1; i <=n ; i++) {
//            gym[i]=in.nextInt();
//        }
//        int result[]=new int[n+1];
//        f(company,gym,result,1,n,0);
//        System.out.println(relax);
//    }
//    public static int relax=Integer.MAX_VALUE;
//    //  0:休息  1:工作  2:健身
//    public static void f(int company[],int gym[],int result[],int i,int n,int counter){
//        if (counter>relax) return;
//        if (i==n+1){
//            if (counter<relax) relax=counter;
//            return;
//        }
//        if (company[i]==0 && gym[i]==0){
//            result[i]=0;
//            counter++;
//            f(company,gym,result,i+1,n,counter);
//            counter--;
//        }
//        if (company[i]!=0 && result[i-1]!=1) {
//            result[i]=1;
//            f(company,gym,result,i+1,n,counter);
//        }
//        if (gym[i]!=0 && result[i-1]!=2) {
//            result[i]=2;
//            f(company,gym,result,i+1,n,counter);
//        }
//        result[i]=0;
//        counter++;
//        f(company,gym,result,i+1,n,counter);
//        counter--;
//    }
}
