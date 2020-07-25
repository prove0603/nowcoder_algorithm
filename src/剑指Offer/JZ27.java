package 剑指Offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/25 17:07
 */

/*
    题目描述
        输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
        则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
        输入描述:

        输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

 */
public class JZ27 {

    public static ArrayList<String> arrayList;

    public ArrayList<String> Permutation(String str) {
        if (str.equals("")) return arrayList;
        arrayList=new ArrayList<>();
        int counter[]=new int[str.length()];
        f(str,0,"",counter);
        return arrayList;
    }

    public static void f(String str,int index,String prefix,int counter[]){
        if (index==str.length()){
            for (int i = 0; i <arrayList.size() ; i++) {
                if (arrayList.get(i).equals(prefix)) return;
            }
            arrayList.add(prefix);
            return;
        }
        for (int i = 0; i <str.length() ; i++) {
            if (counter[i]==0){
                counter[i]=1;
                f(str,index+1,prefix+str.charAt(i),counter);
                counter[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        JZ27 jz27=new JZ27();
        ArrayList<String> arrayList=jz27.Permutation("aa");
        for (int i = 0; i <arrayList.size() ; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
