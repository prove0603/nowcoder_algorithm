package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/13 9:46
 */
public class JZ06 {
//    https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&&tqId=11159&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
    /*
            题目描述
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
//    二分查找  特殊情况 0 1 1 1 1 -> 0 1 1 1 1 || 1 1 0 1 1
    public int minNumberInRotateArray(int [] array) {
        int left=0,right=array.length-1;
        if(array.length==0) return 0;
        while (left<right){
            if (array[left]<array[right]){
                return array[left];
            }
            int mid=left+((right-left)>>1);
            if (array[mid]>array[right]){
                left=mid+1;
            }
            else if (array[mid]<array[right]){
                right=mid;
            }
            else {
                right=right-1;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
//        int arr[]={4,5,6,1,2,3,4};
//        int left=0,right=arr.length-1;
//        while (left<right){
//            int mid=left+((right-left)>>1);
//            if (arr[mid]>arr[right]){
//                left=mid+1;
//            }
//            if (arr[mid]<arr[right]){
//                right=mid;
//            }
//        }
//        System.out.println(arr[left]);
    }
}
