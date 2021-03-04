package leetcode.others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/2/11 14:11
 * @Created by ZhuangJie
 * @Description
 */
public class Question66 {

//    更简单
//public int[] plusOne(int[] digits) {
//    for (int i = digits.length - 1; i >= 0; i--) {
//        if (digits[i] != 9) {
//            digits[i]++;
//            return digits;
//        }
//        digits[i] = 0;
//    }
//    //跳出for循环，说明数字全部是9
//    int[] temp = new int[digits.length + 1];
//    temp[0] = 1;
//    return temp;
//}
    public int[] plusOne(int[] digits) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int tmp,jinwei=0,index=0;
        for (int i = digits.length-1; i >=0 ; i--) {
            if(i==digits.length-1){tmp=(digits[i]+1+jinwei)%10;}
            else {tmp=(digits[i]+jinwei)%10;}
            jinwei=0;
            if (digits[i]!=0 && tmp==0) {jinwei++;}
            deque.addFirst(tmp);
        }
        if (jinwei!=0){
            deque.addFirst(jinwei);
        }
        int[] result=new int[deque.size()];
        for (Integer i:deque) {
            result[index]=i;
            index++;
        }
        return result;
    }
}
