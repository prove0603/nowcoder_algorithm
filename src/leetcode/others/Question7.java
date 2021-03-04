package leetcode.others;



/**
 * @Date 2021/2/3 0:57
 * @Created by ZhuangJie
 * @Description
 */
public class Question7 {
    public int reverse(int x) {
        if (x==0){return 0;}
        int sign=1;
        if (x<0) {sign=-1;}
        StringBuilder builder=new StringBuilder();
        builder.append(x);
        if (sign==-1){
            builder.deleteCharAt(0);
        }
        String max=Integer.MAX_VALUE+"";
        StringBuilder reverse = builder.reverse();
        if (reverse.length()>10){
            return 0;
        }
        if (reverse.length()==10 && max.compareTo(reverse.toString())<0){
            return 0;
        }
        if (sign==1){
            return Integer.parseInt(reverse.toString());
        }else {
            return -Integer.parseInt(reverse.toString());
        }
    }

    public static void main(String[] args) {
//        int x=120;
//        StringBuilder builder=new StringBuilder();
//        builder.append(x);
//        StringBuilder reverse = builder.reverse();
//        System.out.println(Integer.parseInt(reverse.toString()));
        String a="2147483647";
        String b="9646324351";
        System.out.println(a.compareTo(b));
    }
}
