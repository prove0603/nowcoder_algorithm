package leetcode.深度优先;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2021/1/28 0:11
 * @Created by ZhuangJie
 * @Description
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Question17 {
    List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return result;
        }
        String key2="abc";
        String key3="def";
        String key4="ghi";
        String key5="jkl";
        String key6="mno";
        String key7="pqrs";
        String key8="tuv";
        String key9="wxyz";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <digits.length() ; i++) {
            if (digits.charAt(i)=='2'){list.add(key2);continue;}
            if (digits.charAt(i)=='3'){list.add(key3);continue;}
            if (digits.charAt(i)=='4'){list.add(key4);continue;}
            if (digits.charAt(i)=='5'){list.add(key5);continue;}
            if (digits.charAt(i)=='6'){list.add(key6);continue;}
            if (digits.charAt(i)=='7'){list.add(key7);continue;}
            if (digits.charAt(i)=='8'){list.add(key8);continue;}
            if (digits.charAt(i)=='9'){list.add(key9);continue;}
        }
        f(list,0,new StringBuilder());
        return result;
    }

    public void f(ArrayList<String> list,int index,StringBuilder prefix){
        if (index==list.size()){
            result.add(prefix.toString());
            return;
        }
        for (int i = 0; i <list.get(index).length() ; i++) {
            prefix.append(list.get(index).charAt(i));
            f(list,index+1,prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
