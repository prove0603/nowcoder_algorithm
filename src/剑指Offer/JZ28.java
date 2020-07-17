package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/17 16:45
 */

/*
    题目描述
        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
        例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
        由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

 */
public class JZ28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int tmp=-12345;int counter=0;
        for (int i = 0; i <array.length ; i++) {
            if (tmp==array[i]){
                counter++;
            }else if (tmp!=array[i] && counter>1){
                counter--;
            }else {
                tmp=array[i];
                counter=1;
            }
        }
        counter=0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i]==tmp) counter++;
        }
        if (counter> array.length/2) return tmp;
        return 0;
    }
}
