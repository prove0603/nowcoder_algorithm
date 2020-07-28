package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 9:07
 */
    /*
        题目描述
            输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
            所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    */
public class JZ13 {
    public void reOrderArray(int [] array) {
        int arrJi[]=new int[array.length];
        int arrOu[]=new int[array.length];
        int counterJi=0;
        int counterOu=0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i]%2==0){
                arrOu[counterOu]=array[i];
                counterOu++;
            }else{
                arrJi[counterJi]=array[i];
                counterJi++;
            }
        }
        int counter=0;
        for (int i = 0; i <counterJi ; i++) {
            array[counter]=arrJi[i];
            counter++;
        }
        for (int i = 0; i <counterOu ; i++) {
            array[counter]=arrOu[i];
            counter++;
        }
    }

    /*
    也可以利用插入排序的思路
    链接：https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593?f=discussion
来源：牛客网
 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
 * 2.i从左向右遍历，找到第一个偶数。
 * 3.j从i+1开始向后找，直到找到第一个奇数。
 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 * 5.終止條件：j向後遍歷查找失敗。
     */
    public static void main(String[] args) {
        JZ13 jz13=new JZ13();
        int arr[]={1,5,4,3,2,0,1,4,9,8,7,4,2,3,1,5,8,9,6};
        jz13.reOrderArray(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
