package 剑指Offer;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/13 10:52
 * page 44
 */
public class JZ01 {
    /*
    题目描述
        在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
        请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     */

//    题解：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e?answerType=1&f=discussion
//    效率没有达到最高  nlogN
//    public boolean Find(int target, int [][] array) {
//        int leftX=0,leftY=0,rightX=array.length-1,rightY=array[0].length-1;
//        while (leftX<=rightX && leftY<=rightY){
//            int midX=leftX+((rightX-leftX)>>1),midY=leftY+((rightY-leftY)>>1);
//            if (array[midX][midY]==target) return true;
//            else if(array[midX][midY]<target){
//                for(int i=midY;i<=rightY;i++){
//                    if(array[midX][i]==target) return true;
//                }
//                for(int i=midX;i<=rightX;i++){
//                    if(array[i][midY]==target) return true;
//                }
//                leftX=midX+1;
//                leftY=midY+1;
//            }else {
//                for(int i=midY;i>=leftY;i--){
//                    if(array[midX][i]==target) return true;
//                }
//                for(int i=midX;i>=leftX;i--){
//                    if(array[i][midY]==target) return true;
//                }
//                rightX=midX-1;
//                rightY=midY-1;
//            }
//        }
//        return false;
//    }


    //最优解  log(m+n)
    public class Solution {
        public boolean Find(int target, int [][] array) {
            //m代表行  n代表列
            int m=0,n=array[0].length-1;
            while(m<array.length && n>-1){
                if(array[m][n]==target){
                    return true;
                }
                else if(array[m][n]>target){
                    n--;
                }else{
                    m++;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
//        Scanner in =new Scanner(System.in);
//        int arr[][]=new int[4][4];
//        for (int i = 0; i <4 ; i++) {
//            for (int j = 0; j <4 ; j++) {
//                arr[i][j]=in.nextInt();
//            }
//        }
//        System.out.println(Find(16,arr));
    }
}

/*
 测试用例
        1
        2
        3
        4
        5
        2
        3
        4
        5
        6
        3
        4
        5
        6
        7
        4
        5
        6
        7
        8
        5
        6
        7
        8
        9

        1
2
8
9
2
4
9
12
4
7
10
13
6
8
11
15

 */