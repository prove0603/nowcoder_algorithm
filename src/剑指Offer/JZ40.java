package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/16 16:36
 */

/*
    题目描述
        一个整型数组里除了两个数字之外，其他的数字都出现了两次。
        请写程序找出这两个只出现一次的数字。
        num1,num2分别为长度为1的数组。传出参数
        将num1[0],num2[0]设置为返回结果
 */

public class JZ40 {
//    普通方法
//    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
//        int a[]=new int[1000001];
//        for (int i = 0; i <array.length ; i++) {
//            a[array[i]]++;
//        }
//        boolean flag=false;
//        for (int i = 0; i <a.length ; i++) {
//            if (a[i]==1 && flag==false){
//                num1[0]=i;
//                flag=true;
//            }else if (a[i]==1 && flag==true){
//                num2[0]=i;
//            }
//        }
//    }

//    究极技术流
//    https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811?f=discussion
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int length=array.length;
        if (length==2){
            num1[0]=array[0];
            num2[0]=array[1];
            return;
        }
        int result=0;//任何数和0 异或都是其本身
        for (int i = 0; i <length ; i++) {
            result ^=array[i];
        }
        int index=findFirst1(result);
        for (int i = 0; i <length ; i++) {
            if (whether1(array[i],index)){
                num1[0] ^=array[i];
            }else {
                num2[0] ^=array[i];
            }
        }

    }
//    找第一个1
    public static int findFirst1(int result){
        int index=0;
        while ((result & 1)==0 && index<32){
            result >>=1;
            index++;
        }
        return index;
    }

//  判断第index是否为1  !!!注意  ==的优先级高于& !!!
    public static boolean whether1(int number,int index){
        if (((number>>index) & 1) ==0) return false;
        else return true;
    }
}