package 剑指Offer;

import java.util.ArrayList;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/16 14:48
 */

    /*
        题目描述
            小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
            但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
            没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
            现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
        输出描述:
            输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
    */
public class JZ41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> totalList=new ArrayList<>();
        if (sum<=1) return totalList;
//        if (sum==1){
//            ArrayList<Integer> tmp=new ArrayList<>();
//            tmp.add(1);
//            totalList.add(tmp);
//            return totalList;
//        }
        for (int i = 1; i <=sum/2 ; i++) {
            int target=sum-i;
            ArrayList<Integer> tmp=new ArrayList<>();
            tmp.add(i);
            for (int j = i+1; j <=sum/2 ; j++) {
                if (target-j<0) break;
                else if (target-j==0){
                    tmp.add(j);
                    totalList.add(tmp);
                }else {
                    tmp.add(j);
                    target=target-j;
                }
            }
        }
        return totalList;
    }

    public static void main(String[] args) {
        JZ41 jz41=new JZ41();
        ArrayList<ArrayList<Integer>> lists=jz41.FindContinuousSequence(1);
        for (ArrayList<Integer> e:lists) {
            for (int i = 0; i < e.size(); i++) {
                System.out.print(e.get(i)+" ");
            }
            System.out.println();
        }
    }
}
