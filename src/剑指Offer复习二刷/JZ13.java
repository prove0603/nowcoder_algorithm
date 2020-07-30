package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/30 10:44    二刷成功(尝试新方法的途中有些曲折)
 */

    /*
        题目描述
            输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
            所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

     */
public class JZ13 {
    //空间换时间或者插入排序的思想  第一次写的时候使用了空间换时间   所以这次用第二个
    public void reOrderArray(int [] array) {
        //这个方法是错的  做不到稳定   因为每次都和下一个偶数互换   想做到稳定应该是相邻的元素互换
//        for (int i = 0; i <array.length ; i++) {
//            for (int j = i+1; j <array.length ; j++) {
//                if (array[i]%2==0 && array[j]%2==1){
//                    int tmp=array[i];
//                    array[i]=array[j];
//                    array[j]=tmp;
//                }
//            }
//        }
//        这样无法处理连续偶数的情况   所以j应该从后开始往前扫描
//        for (int i = 0; i <array.length ; i++) {
//            for (int j = i; j <array.length-1 ; j++) {
//                if (array[j]%2==0 && array[j+1]%2==1){
//                    int tmp=array[j];
//                    array[j]=array[j+1];
//                    array[j+1]=tmp;
//                }
//            }
//        }
        for (int i = 0; i <array.length ; i++) {
            for (int j = array.length-1; j >=1 ; j--) {
                if (array[j]%2==1 && array[j-1]%2==0){
                    int tmp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=tmp;
                }
            }
        }
    }
}
