package leetcode.others;

import java.util.ArrayDeque;

/**
 * @Date 2021/2/11 15:06
 * @Created by ZhuangJie
 * @Description
 */
public class Question67 {
    public String addBinary(String a, String b) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int min=0,tmp=0;
        int indexA=a.length()-1,indexB=b.length()-1,jinwei=0;
        while (indexA>-1 || indexB>-1){
            if (indexA>-1 && indexB>-1) {tmp=a.charAt(indexA)-'0'+b.charAt(indexB)-'0'+jinwei;}
            else if (indexA>-1){ tmp=a.charAt(indexA)-'0'+jinwei;}
            else {tmp=b.charAt(indexB)-'0'+jinwei;}
            if (jinwei!=0) {jinwei--;}
            if (tmp==0){deque.addFirst('0');}
            else if (tmp==1){deque.addFirst('1');}
            else if (tmp==2){deque.addFirst('0');jinwei++;}
            else {deque.addFirst('1');jinwei++;}
            indexA--;indexB--;
        }
        if(jinwei!=0){
            deque.addFirst('1');
        }
        Character[] array = deque.toArray(new Character[0]);
        StringBuilder builder=new StringBuilder();
        for (Character c:array) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Character[] a={'1','2'};
        System.out.println( String.valueOf(a));
    }
}
