package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/8/6 14:09
 */

/*
    题目描述
        输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
        如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 */
public class JZ23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null || sequence.length==0) return false;
        return f(sequence,0,sequence.length-1);
    }

    public boolean f(int arr[],int start,int root){
        if (start>=root) return true;
        int rootValue=arr[root];
        int i;
//        找到左右子树的分界线
        for (i = start; i <root ; i++) {
            if (arr[i]>rootValue){
                break;
            }
        }
//        判断其右子树是否全部大于根节点
        for (int j = i; j <root ; j++) {
            if (arr[j]<rootValue) return false;
        }
        return (f(arr,start,i-1) && f(arr,i,root-1));
    }

    public static void main(String[] args) {
        JZ23 jz23=new JZ23();
        int arr[]={1,2,4,3,6,9,8,7,5};
        System.out.println(jz23.VerifySquenceOfBST(arr));
    }


    /*
    链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd?answerType=1&f=discussion
    来源：牛客网

    发现对于每一棵子树，它的根结点总是对应该子树的后序序列的最后一个数

    那么，只需要不断地确定出左子树区间和右子树区间，并且判断：左子树区间的所有结点值 < 根结点值 < 右子树区间所有结点值，这个条件是否满足即可

    public class Solution {

        public boolean helpVerify(int [] sequence, int start, int root){
            if(start >= root)return true;
            int key = sequence[root];
            int i;
            //找到左右子数的分界点
            for(i=start; i < root; i++)
                if(sequence[i] > key)
                    break;
            //在右子树中判断是否含有小于root的值，如果有返回false
            for(int j = i; j < root; j++)
                if(sequence[j] < key)
                    return false;
            return helpVerify(sequence, start, i-1) && helpVerify(sequence, i, root-1);
        }
        public boolean VerifySquenceOfBST(int [] sequence) {
            if(sequence == null || sequence.length == 0)return false;
            return  helpVerify(sequence, 0, sequence.length-1);

        }
    }
     */


}
