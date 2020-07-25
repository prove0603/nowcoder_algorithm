package 剑指Offer;

import java.util.ArrayList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/25 10:01
 */

/*
    题目描述
        把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
        习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

//太复杂
        1.求出所有质因子（100个）
        2.每个数字遍历质因子集合

//丑数=丑数*2 | *3  |*5

https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?f=discussion
 */
public class JZ33 {
//    太复杂
//    public int GetUglyNumber_Solution(int index) {
//        if (index==1) return 1;
//        ArrayList<Integer> list=getZhiYinZi();
//        int counter=1;
//        for (int i = 2; i <859963399 ; i++) {
//            boolean flag1=false,flag2=true;
//            if (i%2==0 || i%3==0 || i%5==0) flag1=true;
//            for (int j = 3; j <list.size() ; j++) {
//                if (i<list.get(j)) break;
//                if (i%list.get(j)==0){
//                    flag2=false;
//                    break;
//                }
//            }
//            if (flag1 && flag2){
//                counter++;
//                if (counter==index) return i;
//            }
//        }
//        return -1;
//    }
//
//    public static ArrayList<Integer> getZhiYinZi(){
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        arrayList.add(2);arrayList.add(3);arrayList.add(5);
//        for (int i = 6; i <100000 ; i++) {
//            boolean flag=true;
//            for (int j = 2; j*j<=i ; j++) {
//                if (i%j==0){
//                    flag=false;
//                    break;
//                }
//            }
//            if (flag){
//                arrayList.add(i);
//            }
//        }
//        return arrayList;
//    }

    public int GetUglyNumber_Solution(int index) {
        if(index<7) return index;
        int arr[]=new int[index+1];
        arr[0]=1;
//        3个指针 分别代表 *2 *3 *5
        int t2=0,t3=0,t5=0,current=1;
        for (int i = 0; i <index ; i++) {
            int min=Math.min(arr[t2]*2,Math.min(arr[t3]*3,arr[t5]*5));
            arr[current]=min;
            current++;
//            不能是else-if  因为可能会出现相同的情况 譬如2*3  与3*2
            if (min==arr[t2]*2) t2++;
            if (min==arr[t3]*3) t3++;
            if (min==arr[t5]*5) t5++;
        }
        return arr[index-1];

    }
    public static void main(String[] args) {

    }
}
