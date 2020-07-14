package 剑指Offer;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/13 14:50
 */
public class JZ51 {

    /*
    题目描述
        给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
        不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     */
    //https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46?answerType=1&f=discussion

        public int[] multiply(int[] A) {
            int b[]=new int[A.length];
            for (int i = 0; i <A.length ; i++) {
                b[i]=1;
            }
            for (int i = 1; i <A.length ; i++) {
                b[i]=b[i-1]*A[i-1];
            }
            int tmp=1;
            for (int i = A.length-2; i >=0 ; i--) {
                tmp*=A[i+1];
                b[i]*=tmp;
            }
            return b;
        }
}
