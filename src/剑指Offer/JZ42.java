package 剑指Offer;

import java.util.ArrayList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/16 14:13
 */

    /*
        题目描述
            输入一个递增排序的数组和一个数字S，在数组中查找两个数，
            使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    */
public class JZ42 {

//    这样不够精简  使用了for嵌套  实际上循环一边就够了 因为如果 arr[i]+a[j]>sum  则下一次计算i+1时  不需要再计算j了 因为是递增的
//    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
//        ArrayList<Integer> list=new ArrayList<>();
//        int min=Integer.MAX_VALUE;
//        for (int i = 0; i <array.length ; i++) {
//            int target=sum-array[i];
//            for (int j = array.length-1; j >i ; j--) {
//                if (target>array[j]) break;
//                if (target==array[j]){
//                    int tmp=array[i]*array[j];
//                    if (tmp<min){
//                        min=tmp;
//                        list.clear();
//                        list.add(array[i]);
//                        list.add(array[j]);
//                    }
//                }
//            }
//        }
//        return list;
//    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int i=0,j=array.length-1;
        while (i<j){
            if (array[i]+array[j]==sum){
                int tmp=array[i]*array[j];
                if (tmp<min) {
                    min=tmp;
                    list.clear();
                    list.add(array[i]);
                    list.add(array[j]);
                }
                i++;
                j--;
            }
            else if (array[i]+array[j]>sum){
                j--;
            }else {
                i++;
            }
        }
        return list;
    }
}
