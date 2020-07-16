package 剑指Offer;

import java.util.ArrayList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/14 13:52
 */

/*
    题目描述
        给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
        每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
        例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
        输入描述:

        输入一个数n，意义见题面。（2 <= n <= 60）

        输出描述:

        输出答案。

        示例1
        输入
        复制

        8

        输出
        复制

        18

 */
public class JZ67 {

    /* 暴力递归法
    public static int max=0;
    public static int cutRope(int target) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        f(target,arrayList);
        return max;
    }
    public static void f(int target, ArrayList<Integer> arr){
        if (target==0){
            int sum=1;
            for (int i = 0; i <arr.size() ; i++) {
                sum*=arr.get(i);
            }
            if (sum>max){
                max=sum;
            }
            return;
        }
        for (int i = 1; i <=target ; i++) {
            if (target-i<0) break;
            arr.add(i);
            f(target-i,(ArrayList<Integer>) arr.clone());
            arr.remove(arr.size()-1);
        }
    }

     */




/**问题描述
 * 给你一根长度为n的绳子，把绳子剪成m段（m、n都是整数且m > 1, n > 1）,m段绳子的长度依然是整数，求m段绳子的长度乘积最大为多少？
 * 比如绳子长度为8，我们可以分成2段、3段、4段...8段，只有分成3段且长度分别是2、3、3时能得到最大乘积18
 */

    /**
     * 动态规划法：
     * 动态规划求解问题的四个特征：
     ①求一个问题的最优解；
     ②整体的问题的最优解是依赖于各个子问题的最优解；
     ③小问题之间还有相互重叠的更小的子问题；
     ④从上往下分析问题，从下往上求解问题；
     * 动态规划：
     有一段长度为n的绳子，我们现在要剪第一刀，我可以选择下第一刀的地方有1~n-1这些地方；比如长度为10的绳子，我第一刀可以在1~9这些地方下刀，共9种方式。
     第一刀下去后，绳子分成两部分，假设在i处下刀，绳子两部分就分别为：[0~i]与[i~n]，长度分为表示为i与n-i；那么找出第一刀最合适的位置，其实就是找i在哪下刀，可以使得[0~i]与[i~n]的乘积最大，函数表示为：f(n)=max(f(i)×f(n−i))f(n)=max(f(i)×f(n−i))。
     那么如何判断i处切最大呢？这个时候，我们就要知道，[0~i]这个长度的绳子，任意方式切，最大的乘积是多少；假如说，当我们要切一个长度为10的绳子：切成1和9与4和6，两种方式，哪个乘积更大？
     回答：不光要考虑第一刀后两个绳子的大小，还要考虑到9、4、6这三种情况，因为第一刀切出的绳子长度是否可以再切第二刀，使它有更大的乘积，比如将9再切成 3×3×33×3×3，6切成 4×24×2，哪个更大？
     这种情况下，我们可以发现，无论再怎么切，一定是越切越短，那么我们是否可以将小于给定长度的绳子的每一个长度的最大乘积都求出来？
     即：长度为10的绳子，我们就计算出：长度1~9这9种长度的绳子，每种长度的最大乘积是多少。
                   要求长度9的绳子的最大乘积，我们要知道1~8各个长度的最大乘积，要知道长度8的最大乘积，就要知道1~7长度的各个最大乘积，以此类推。
     *
     * 动态规划版本
     * f(n)定义为将长度为n的绳子分成若干段后的各段长度的最大乘积（最优解），在剪第一刀时有n-1种剪法，可选择在0 < i < n处下刀
     * 在i处下刀，分成长度为i的左半绳子和长度为n-i的右半绳子，对于这两根绳子，定义最优解为f(i)和f(n-i)，于是f(n) = max(f(i) * f(n-i))，即求出各种相乘可能中的最大值就是f(n)的最优解
     * 就这样从上到下的分下去，但是问题的解决从下到上。即先求出f(2)、f(3)的最优解，然后根据这两个值求出f(4)、f(5)...直到f(n)
     * f(2) = 1，因为只能分成两半
     * f(3) = 2，因为分成两段2*1 大于分成三段的1*1*1
     * ...
     */
    public static int maxProductAfterCutting(int length){
        if (length==1) return 0;
        if (length==2) return 1;
        if (length==3) return 2;

        int arr[]=new int[length+1];
//        这三个值记录的是参与计算时候的值  ！！！  注意区分
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        for (int i = 4; i <=length ; i++) {
            int tmpMax=-1;
            for (int j = 1; j <=i/2 ; j++) {
                if (arr[j]*arr[i-j]>tmpMax){
                    tmpMax=arr[j]*arr[i-j];
                }
            }
            arr[i]=tmpMax;
        }
        return arr[length];
    }

    /**
     * 贪心算法
     *
     * n<2时，返回0；n=2时，返回1；n=3时，返回2
     * 根据数学计算，当n>=5时，2(n-2)>n，3(n-3)>n，这就是说，将绳子剪成2和(n-2)或者剪成3和(n-3)时，乘积大于不剪的乘积，
     * 因此需要把绳子剪成2或者3。并且3(n-3)>=2(n-2)，也就是说，当n>=5时，应该剪尽量多的3，
     * 可以使最后的乘积最大。对于长度是n的绳子，我们可以剪出n/3个3，剩余长度是1或者2，
     * 如果余数是1，就可以把1和最后一个3合并成4，那么4剪出两个2得到的乘积是4，比1*3大，
     * 因此这种情况下，需要将3的个数减少1，变成两个2；如果余数是2，那么无需做修改。
     * 可以得到最大的乘积是：3^timesOf3 * 2^timesOf2；
     *
     * 版权声明：本文为CSDN博主「Jerry没有Tom」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/DEMON3344/article/details/85309025
     */
    public static int maxProductAfterCutting2(int length) {
        // 长度为1时不满足题意，返回0
        if (length < 2) {
            return 0;
        }
        // f(2)
        if (length == 2) {
            return 1;
        }
        // f(3)
        if (length == 3) {
            return 2;
        }
        //     统计能分出多少段长度为3的绳子
        int timesOf3 = length / 3;
        // 如果最有只剩下长度为1的绳子，需要退一步，得到长度为4的绳子，重新分成2*2的
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        // 到这步length - timesOf3 * 3的值只可能是0,2,4，所以timesOf2只可能是0, 1, 2
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(60));
    }
}