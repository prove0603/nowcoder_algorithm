package leetcode.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2021/1/25 19:21
 * @Created by ZhuangJie
 * @Description
 * 最大数
 * https://leetcode-cn.com/problems/largest-number/
 */
public class Question179 {
    public String largestNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:nums) {
            list.add(i);
        }
        Collections.sort(list,(o1,o2)->{
            int tmpa=o1,tmpb=o2,digitA=1,digitB=1;
            while (tmpa/digitA!=0){
                digitA*=10;
            }
            while (tmpb/digitB!=0){
                digitB*=10;
            }
            if (o1*(digitA-1)+o2>=o2*(digitB-1)+o1){
                return 1;
            }else if(o1*(digitA-1)+o2<o2*(digitB-1)+o1){
                return -1;
            }else{
                return 0;
            }
        });
        StringBuilder builder=new StringBuilder();
        for (Integer integer:list) {
            builder.append(integer);
        }
        return builder.toString();
    }
}
