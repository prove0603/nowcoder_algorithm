package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/21 9:28
 */
/*
    题目描述
        地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
        但是不能进入行坐标和列坐标的数位之和大于k的格子。
        例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
        但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

 */
public class JZ66 {

    public static int arr[][];

    public static int threshold1=0;

    public static int movingCount(int threshold, int rows, int cols) {
        arr=new int[rows][cols];
        threshold1=threshold;
        f(0,0);
        int counter=0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (arr[i][j]==1) counter++;
            }
        }
        return counter;
    }

    public static void f(int rows,int cols){
        if (rows>arr.length-1 || rows<0) return ;
        if (cols>arr[0].length-1 || cols<0) return ;
        if (arr[rows][cols]==1) return;
        int tmp=countSum(rows,cols);
        if (countSum(rows,cols)<=threshold1){
            arr[rows][cols]=1;
            f(rows-1,cols);
            f(rows,cols+1);
            f(rows+1,cols);
            f(rows,cols-1);
        }
    }
    public static int countSum(int a,int b){
        int sum=0;
        while (a!=0){
            sum+=a%10;
            a/=10;
        }
        while (b!=0){
            sum+=b%10;
            b/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(15,20,20));
    }
}
