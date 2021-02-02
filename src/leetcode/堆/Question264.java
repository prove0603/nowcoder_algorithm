package leetcode.堆;

/**
 * @Date 2020/12/28 0:33
 * @Created by ZhuangJie
 * @Description
 * 丑数 II
 * https://leetcode-cn.com/problems/ugly-number-ii/
 */
public class Question264 {
    public int nthUglyNumber(int n) {
        if (n<7) return n;
        int arr[]=new int[n+1];
        arr[0]=1;
        int index2=0,index3=0,index5=0,current=0;
        for (int i = 1; i <=n ; i++) {
            int min=Math.min(arr[index2]*2,Math.min(arr[index3]*3,arr[index5]*5));
            arr[current]=min;
            if (min==arr[index2]*2) index2++;
            if (min==arr[index3]*3) index3++;
            if (min==arr[index5]*5) index5++;
        }
        return arr[n-1];
    }
}
