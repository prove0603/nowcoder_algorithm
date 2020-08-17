package 笔试真题.字节跳动2019春招研发部分编程题汇总;
import java.util.*;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/14 16:05
 */
/*
     小明是一名算法工程师，同时也是一名铲屎官。某天，他突发奇想，想从猫咪的视频里挖掘一些猫咪的运动信息。为了提取运动信息，他需要从视频的每一帧提取“猫咪特征”。一个猫咪特征是一个两维的vector<x, y>。如果x_1=x_2 and y_1=y_2，那么这俩是同一个特征。
       因此，如果喵咪特征连续一致，可以认为喵咪在运动。也就是说，如果特征<a, b>在持续帧里出现，那么它将构成特征运动。比如，特征<a, b>在第2/3/4/7/8帧出现，那么该特征将形成两个特征运动2-3-4 和7-8。
现在，给定每一帧的特征，特征的数量可能不一样。小明期望能找到最长的特征运动。

    输入描述:

    第一行包含一个正整数N，代表测试用例的个数。

    每个测试用例的第一行包含一个正整数M，代表视频的帧数。

    接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
    所有用例的输入特征总数和<100000

    N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
    特征取值均为非负整数。


    输出描述:

    对每一个测试用例，输出特征运动的长度作为一行


    输入例子1:

    1
    8
    2 1 1 2 2
    2 1 1 1 4
    2 1 1 2 2
    2 2 2 1 4
    0
    0
    1 1 1
    1 1 1

    输出例子1:

    3

    例子说明1:

    特征<1,1>在连续的帧中连续出现3次，相比其他特征连续出现的次数大，所以输出3

    https://www.nowcoder.com/questionTerminal/5afcf93c419a4aa793e9b325d01957e2
 */



public class Question4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 0; i <n ; i++) {
            int max=1;
            int m=in.nextInt();
            HashMap<String,Integer> map=new HashMap<>();
            HashMap<String,Integer> tmp_map=new HashMap<>();
            for (int j = 0; j <m ; j++) {
                int index=in.nextInt();
                tmp_map.clear();
                for (int k = 0; k <index ; k++) {
                    int x=in.nextInt();
                    int y=in.nextInt();
                    String key=String.valueOf(x)+"-"+String.valueOf(y);
                    tmp_map.put(key,map.getOrDefault(key,0)+1);
                    max=Math.max(max,tmp_map.get(key));
                }
                map.clear();
                map.putAll(tmp_map);

            }
            if (max<=1) System.out.println(1);
            else System.out.println(max);
        }
    }
}