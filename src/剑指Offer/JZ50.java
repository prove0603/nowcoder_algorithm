package 剑指Offer;

import java.util.HashSet;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/15 13:49
 */

/*
    题目描述
        在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
        请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

 */
public class JZ50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,
    //    so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        HashSet<Integer> hashSet=new HashSet<>();
        int size=hashSet.size();
        for (int i = 0; i <length ; i++) {
            hashSet.add(numbers[i]);
            if (size==hashSet.size()){
                duplication[0]=numbers[i];
                return true;
            }else {
                size++;
            }
        }
        return false;
    }

    /*
    链接：https://www.nowcoder.com/questionTerminal/623a5ac0ea5b4e5f95552655361ae0a8?answerType=1&f=discussion

方法一中的一个条件我们没有用到。也就是数据的范围是0-n-1。所以我们可以这么做：

    设置一个指针i指向开头0，

    对于arr[i]进行判断，如果arr[i] == i， 说明下标为i的数据正确的放在了该位置上，让i++

    如果arr[i] != i, 说明没有正确放在位置上，那么我们就把arr[i]放在正确的位置上，也就是交换
    arr[i] 和arr[arr[i]]。交换之后，如果arr[i] ！= i, 继续交换。

    如果交换的过程中，arr[i] == arr[arr[i]]，说明遇到了重复值，返回即可。
     */
//    注意几个下标是tmp  而不是numbers[numbers[i]]
    public static boolean duplicate2(int numbers[],int length,int [] duplication) {
        for (int i = 0; i <length ; i++) {
            while (numbers[i]!=i){
                int tmp=numbers[i];
                numbers[i]=numbers[numbers[i]];
                numbers[tmp]=tmp;
                if (numbers[i]==numbers[tmp]){
                    duplication[0]=numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int numbers[]={2,1,3,0,4};
        System.out.println(duplicate2(numbers,numbers.length,new int[5]));
    }
}
