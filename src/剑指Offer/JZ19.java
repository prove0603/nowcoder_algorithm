package 剑指Offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/27 16:06
 */
/*
    题目描述
        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
        例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

 */
public class JZ19 {

    public static int helper[][];
    public static int sum;

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return arrayList;
        helper=new int [matrix.length][matrix[0].length];
        sum=matrix.length*matrix[0].length;
        goRight(arrayList,matrix,0,0,0);
        return arrayList;
    }

    public void goRight(ArrayList<Integer> arrayList,int [][] matrix,int x,int y,int counter){
        int tmpY=y;
        for (int i = y; i <matrix[0].length ; i++) {
            if (helper[x][i]==1) break;
            helper[x][i]=1;
            arrayList.add(matrix[x][i]);
            counter++;
            tmpY=i;
        }
        if (counter==sum) return;
        goDown(arrayList,matrix,x+1,tmpY,counter);
    }

    public void goDown(ArrayList<Integer> arrayList,int [][] matrix,int x,int y,int counter){
        int tmpX=x;
        for (int i = x; i <matrix.length ; i++) {
            if (helper[i][y]==1) break;
            helper[i][y]=1;
            arrayList.add(matrix[i][y]);
            counter++;
            tmpX=i;
        }
        if (counter==sum) return;
        goLeft(arrayList,matrix,tmpX,y-1,counter);
    }

    public void goLeft(ArrayList<Integer> arrayList,int [][] matrix,int x,int y,int counter){
        int tmpY=y;
        for (int i = y; i >=0 ; i--) {
            if (helper[x][i]==1) break;
            helper[x][i]=1;
            arrayList.add(matrix[x][i]);
            counter++;
            tmpY=i;
        }
        if (counter==sum) return;
        goUp(arrayList,matrix,x-1,tmpY,counter);
    }

    public void goUp(ArrayList<Integer> arrayList,int [][] matrix,int x,int y,int counter){
        int tmpX=x;
        for (int i = x; i >=0 ; i--) {
            if (helper[i][y]==1) break;
            helper[i][y]=1;
            arrayList.add(matrix[i][y]);
            counter++;
            tmpX=i;
        }
        if (counter==sum) return;
        goRight(arrayList,matrix,tmpX,y+1,counter);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        JZ19 jz19=new JZ19();
        int a=in.nextInt();int b=in.nextInt();
        int matrix[][]=new int[a][b];
        for (int i = 0; i <a ; i++) {
            for (int j = 0; j <b ; j++) {
                matrix[i][j]=in.nextInt();
            }
        }
        ArrayList<Integer> arrayList=jz19.printMatrix(matrix);
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.print(arrayList.get(i)+" ");
        }
    }
}
