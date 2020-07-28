package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/28 11:09
 */

    /*
        题目描述
            在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
            输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
            输入描述:

            题目保证输入的数组中没有的相同的数字

            数据范围：

                对于%50的数据,size<=10^4

                对于%75的数据,size<=10^5

                对于%100的数据,size<=2*10^5

            示例1
            输入
            1,2,3,4,5,6,7,0
            输出
            7
    */
public class JZ35 {
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        int result=nixu%1000000007;
        return result;
    }

    public  void mergeSort(int arr[],int start,int end){
        if (start<end){
            int middle=start+((end-start)>>1);
            mergeSort(arr,0,middle);
            mergeSort(arr,middle+1,end);
            merge(arr,start,middle,end);
        }
    }

    public static int helper[]=new int[200001];
    public static int nixu=0;

    public  void merge(int arr[],int start,int middle,int end){
        System.arraycopy(arr,start,helper,start,end-start+1);
        int current=start, left=start,right=middle+1;
        while (left<=middle && right<=end){
            if (helper[left]<=helper[right]){
                arr[current]=helper[left];
                left++;
                current++;
            }else {
                arr[current]=helper[right];
                right++;
                current++;
                nixu=(nixu+middle-left+1)%1000000007;
            }
        }
        while (left<=middle){
            arr[current]=helper[left];
            current++;
            left++;
        }
    }

    public static void main(String[] args) {
        JZ35 jz35=new JZ35();
        int arr[]={1,2,3,4,5,6,7,0,2,3,4,5,1,2,3,1,55,33,22,11,86,44334,34,2,3,5,79,8,10};
        System.out.println(jz35.InversePairs(arr));
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
