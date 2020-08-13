package 笔试真题.腾讯2020校园招聘后台;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/13 9:49
 */

/*

小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？
（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）

输入描述:

输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
1<=n<=100000;
1<=wi<=100000;


输出描述:

输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。


输入例子1:

6
5 3 8 3 2 5


输出例子1:

3 3 5 4 4 4


例子说明1:

当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，
共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。


 */
public class Question2 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=in.nextInt();
        }
        int left[]=new int[n];  //往左看
        int right[]=new int[n];  //往右看
        Stack<Integer> stack=new Stack<>();
        for (int i = 1; i <n ; i++) {
            if (stack.isEmpty()) stack.push(arr[i-1]);
            else {
                while (!stack.isEmpty() && stack.peek()<=arr[i-1]){
                    stack.pop();
                }
                stack.push(arr[i-1]);
            }
            left[i]=stack.size();
        }
        stack.clear();
        for (int i =n-2; i >=0 ; i--) {
            if (stack.isEmpty()) stack.push(arr[i+1]);
            else {
                while (!stack.isEmpty() && stack.peek()<=arr[i+1]){
                    stack.pop();
                }
                stack.push(arr[i+1]);
            }
            right[i]=stack.size();
        }
        for (int i = 0; i <n ; i++) {
            System.out.print(left[i]+right[i]+1);
            if (i!=n-1) System.out.print(" ");
        }
    }
}
