package leetcode.others;

/**
 * @Date 2021/2/6 0:58
 * @Created by ZhuangJie
 * @Description
 */
public class Question88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m==0 && n==0) {return;}
        int indexA=m-1,indexB=n-1,current=m+n-1;
        for (int i = current; i >=0 ; i--) {
            if(indexA<0 || indexB<0) {break;}
            if (nums1[indexA]<=nums2[indexB]){
                nums1[current]=nums2[indexB];
                indexB--;
                current--;
            }else {
                nums1[current]=nums1[indexA];
                indexA--;
                current--;
            }
        }
        while(indexB>=0) {
            nums1[current]=nums2[indexB];
            indexB--;
            current--;
        }
    }
}
