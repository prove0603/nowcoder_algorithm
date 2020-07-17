package 剑指Offer;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/17 10:00
 */

/*
    题目描述
        统计一个数字在排序数组中出现的次数。

 */
public class JZ37 {
    public int GetNumberOfK(int [] array , int k) {
        int left=findFirstK(array,k,0,array.length-1);
        int right=findLastK(array,k,0,array.length-1);
        if (left==-1 || right==-1){
            return 0;
        }else {
            return right-left+1;
        }
    }

    public int findFirstK(int arr[],int k,int start,int end){
        if (start>end){
            return -1;
        }
        int middle=start+((end-start)>>1);
        if (arr[middle]>k){
            return findFirstK(arr,k,start,middle-1);
        }else if (arr[middle]<k){
            return findFirstK(arr,k,middle+1,end);
        }else if (middle-1>=0 && arr[middle-1]==k){
            return findFirstK(arr,k,start,middle-1);
        }else {
            return middle;
        }
    }

    public int findLastK(int arr[],int k,int start,int end){
        while (start<=end){
            int middle=start+((end-start)>>1);
            if (arr[middle]>k){
                end=middle-1;
            }else if (arr[middle]<k){
                start=middle+1;
            }else if (middle+1<=arr.length-1 && arr[middle+1]==k){
                start=middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JZ37 jz37=new JZ37();
        int arr[]={3,3,3,3};
        Arrays.sort(arr);
        System.out.println(jz37.GetNumberOfK(arr,3));
    }
}
