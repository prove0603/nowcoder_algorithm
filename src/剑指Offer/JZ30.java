package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/17 14:53
 */
/*
    题目描述
        HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
        他又发话了:在古老的一维模式识别中,
        常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
        是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
        连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，
        你会不会被他忽悠住？(子向量的长度至少是1)

 */
public class JZ30 {

//    可以使用动态规划
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0) return 0;
        //代表 以i为结束点的连续子序列和的最大值
        int sum[]=new int[array.length];
        int res=array[0];
        sum[0]=array[0];
        for (int i = 1; i <array.length ; i++) {
            sum[i]=Math.max(sum[i-1]+array[i],array[i]);
            res=Math.max(res,sum[i]);
        }
        return res;
    }


/*
        链接：https://www.nowcoder.com/questionTerminal/459bd355da1549fa8a49e350bf3df484?f=discussion
        来源：牛客网

        使用动态规划
        F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
        F（i）=max（F（i-1）+array[i] ， array[i]）
        res：所有子数组的和的最大值
        res=max（res，F（i））

        如数组[6, -3, -2, 7, -15, 1, 2, 2]
        初始状态：
            F（0）=6
            res=6
        i=1：
            F（1）=max（F（0）-3，-3）=max（6-3，3）=3
            res=max（F（1），res）=max（3，6）=6
        i=2：
            F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
            res=max（F（2），res）=max（1，6）=6
        i=3：
            F（3）=max（F（2）+7，7）=max（1+7，7）=8
            res=max（F（2），res）=max（8，6）=8
        i=4：
            F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
            res=max（F（4），res）=max（-7，8）=8
        以此类推
 */


//    public int FindGreatestSumOfSubArray(int[] array) {
//        int tmp[]=new int[array.length];
//        int index=0,counter=array[0];
//        for (int i = 1; i <array.length ; i++) {
//            if ( (array[i]>=0 && array[i-1]>=0) || (array[i]<0 && array[i-1]<0) ){
//                counter+=array[i];
//            }else{
//                tmp[index]=counter;
//                index++;
//                counter=array[i];
//            }
//        }
//        tmp[index]=counter;
//        index++;
//        int max=-1;
//        int result=0;
//        for (int i = 0; i <index ; i++) {
//            if (tmp[i]>=0){
//                if (result<0){
//                    result=tmp[i];
//                }else {
//                    result += tmp[i];
//                }
//                if (result>max){
//                    max=result;
//                }
//            }else if (tmp[i]<0 && (i==0 || i==index-1)){
//                continue;
//            }else if (tmp[i+1]>=tmp[i]){
//                result+=tmp[i];
//                if (result>max){
//                    max=result;
//                }
//            }else {
//                result=0;
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
//        JZ30 jz30=new JZ30();
//        int arr[]={1,-2,3,10,-4,7,2,-5};
//        System.out.println(jz30.FindGreatestSumOfSubArray(arr));
    }
}
