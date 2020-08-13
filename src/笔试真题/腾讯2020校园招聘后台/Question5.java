package 笔试真题.腾讯2020校园招聘后台;

import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/13 14:45
 */
/*

        小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道
        ,即可以看作是[0,L]的一条数轴。
        这款竞技游戏当中有n个可以提供视野的道具−真视守卫,第i个真视守卫能够覆盖区间[xi,yi]。
        现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。

        输入描述:

        输入包括n+1行。

        第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)

        接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。


        输出描述:

        一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。


        输入例子1:

        4 6
        3 6
        2 4
        0 2
        4 7


        输出例子1:

        3


 */
public class Question5 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int l=in.nextInt();
        int x[]=new int[n];
        int y[]=new int[n];
        for (int i = 0; i <n ; i++) {
            x[i]=in.nextInt();
            y[i]=in.nextInt();
        }
        in.close();
        int arr[]=new int[l+1];
        for (int i = 0; i <n ; i++) {
            for (int j = x[i]; j <=y[i] && j<=l ; j++) {
                arr[j]++;
            }
        }
        f(x,y,arr,0,l,n);
        System.out.println(min);
    }
    public static int min=Integer.MAX_VALUE;
    public static void f(int x[],int y[],int arr[],int i,int l,int counter){
        if (counter<min){
            min=counter;
        }
        if (i==x.length){
            return;
        }
        remove(arr, x, y, i, l);
        if (check(arr)){
            f(x, y, arr, i+1, l, counter-1);
            add(arr, x, y, i, l);
        }else {
            add(arr, x, y, i, l);
        }
        f(x, y, arr, i+1, l, counter);
    }
    public static void remove(int arr[],int x[],int y[],int i,int l){
        for (int j = x[i]; j <=y[i] && j<=l ; j++) {
            arr[j]--;
        }
    }
    public static void add(int arr[],int x[],int y[],int i,int l){
        for (int j = x[i]; j <=y[i] && j<=l ; j++) {
            arr[j]++;
        }
    }
    public static boolean check(int arr[]){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==0) return false;
        }
        return true;
    }
}
