package leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/2/6 1:24
 * @Created by ZhuangJie
 * @Description
 */
public class Question118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows==0) {return result;}
        int counter=0;
        while (counter!=numRows){
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i <=counter ; i++) {
                if (i==0 || i==counter){
                    tmp.add(1);
                }else {
                    tmp.add(result.get(counter-1).get(i-1)+result.get(counter-1).get(i));
                }
            }
            result.add(tmp);
            counter++;
        }
        return result;
    }
}
