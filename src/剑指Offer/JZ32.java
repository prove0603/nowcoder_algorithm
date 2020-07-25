package 剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/25 15:17
 */

/*
    题目描述
        输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
        例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class JZ32 {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i <numbers.length ; i++) {
            arrayList.add(numbers[i]);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a=o1+""+o2;
                String b=o2+""+o1;
                return Integer.parseInt(a)>=Integer.parseInt(b)?1:-1;
            }
        });
        StringBuilder stringBuilder=new StringBuilder();
        for (Integer e:arrayList) {
            stringBuilder.append(e);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        JZ32 jz32=new JZ32();
        int a[]={3,32,321};
//        System.out.println(jz32.PrintMinNumber(a));
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(list.get(0));
    }
}
