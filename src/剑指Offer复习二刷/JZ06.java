package 剑指Offer复习二刷;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 17:06    二刷成功
 */

/*
    题目描述
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class JZ06 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0) return 0;
        return f(array,0,array.length-1);
    }

    public static int f(int arr[],int start,int end){
        if (start==end) return arr[start];
        int middle=start+((end-start)>>1);
        if (arr[middle]>arr[end]){
            return f(arr,middle+1,end);
        }else if (arr[middle]<arr[end]){
            return f(arr,start,middle);
        }else return f(arr,start,end-1);
    }

    public static void main(String[] args) {
        int arr[]={1,1,1,0,1};
        JZ06 jz06=new JZ06();
        System.out.println(jz06.minNumberInRotateArray(arr));
    }
}
