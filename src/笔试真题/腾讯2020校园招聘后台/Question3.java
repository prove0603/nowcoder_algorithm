package 笔试真题.腾讯2020校园招聘后台;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/13 10:17
 */

/*
        作为程序员的小Q，他的数列和其他人的不太一样，他有个数。
        老板问了小Q一共 m次，每次给出一个整数, 要求小Q把这些数每分为一组，然后把每组进行翻转，
        小Q想知道每次操作后整个序列中的逆序对个数是多少呢？

        例如:
        对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
        翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。

        输入描述:

        第一行一个数
        第二行个数，表示初始的序列()
        第三行一个数
        第四行m个数表示


        输出描述:

        m行每行一个数表示答案。


        输入例子1:

        2
        2 1 4 3
        4
        1 2 0 2


        输出例子1:

        0
        6
        6
        0


        例子说明1:

        初始序列2 1 4 3
        2^{q_1} = 2 ->
        第一次：1 2 3 4 -> 逆序对数为0
        2^{q_2} = 4 ->
        第二次：4 3 2 1 -> 逆序对数为6
        2^{q_3} = 1 ->
        第三次：4 3 2 1 -> 逆序对数为6
        2^{q_4} = 4 ->
        第四次：1 2 3 4 -> 逆序对数为0

 */
public class Question3 {

    public static int nixu = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[(int) Math.pow(2, n)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int arrq[] = new int[m];
        for (int i = 0; i < m; i++) {
            arrq[i] = (int) Math.pow(2, in.nextInt());
        }
        in.close();
        for (int i = 0; i < m; i++) {
            reverse(arr, arrq[i]);
//            print(arr);
            int tmp[]=arr.clone();
            nixu(tmp,0,arr.length-1);
            System.out.println(nixu);
            nixu=0;
        }
    }

    public static void print(int arr[]){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
            if (i==arr.length-1) System.out.println();
        }
    }
    //数组翻转
    public static void reverse(int arr[], int number) {
        if (number == 1 ) return;
        int begin = 0;
        while (begin < arr.length) {
            int end = begin + 1;
            while (end - begin + 1 != number) {
                end++;
            }
            reverse(arr, begin, end);
            begin = end + 1;
        }
    }

    public static void reverse(int arr[], int start, int end) {
        if (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            reverse(arr, start + 1, end - 1);
        }
    }

    public static void nixu(int arr[], int start, int end) {
        if (start < end) {
            int middle = start + ((end - start) >> 1);
            nixu(arr, start, middle);
            nixu(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    public static int helper[] = new int[(int) Math.pow(2, 20)];

    public static void merge(int arr[], int start, int middle, int end) {
        System.arraycopy(arr, start, helper, start, end - start + 1);
        int current = start, left = start, right = middle + 1;
        while (left <= middle && right <= end) {
            if (helper[left] <= helper[right]) {
                arr[current] = helper[left];
                current++;
                left++;
            } else {
                arr[current] = helper[right];
                nixu += middle - left + 1;
                current++;
                right++;
            }
        }
        while (left <= middle) {
            arr[current] = helper[left];
            current++;
            left++;
        }
    }
}
