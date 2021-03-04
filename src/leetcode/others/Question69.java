package leetcode.others;

/**
 * @Date 2021/2/10 20:19
 * @Created by ZhuangJie
 * @Description
 */
public class Question69 {
    public int mySqrt(int x) {
        if(x==0) {return 0;}
        if(x==1) {return 1;}
        long start=1,end=x/2,middle=0;
        long tmp,tmp2;
        while (start<=end){
            middle=(start+end)>>1;
            tmp=middle*middle;
            if (tmp>x){
                end=middle-1;
            }else if (tmp<x){
                start=middle+1;
            }else {
                return (int)middle;
            }
        }
        return (int)Long.min(start, end);
    }

    public static void main(String[] args) {
        long a=(long)Integer.MAX_VALUE+1;
        System.out.println(a);
    }
}
