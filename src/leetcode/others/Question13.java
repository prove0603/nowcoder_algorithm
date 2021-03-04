package leetcode.others;

/**
 * @Date 2021/2/3 1:26
 * @Created by ZhuangJie
 * @Description
 */
public class Question13 {
    public int romanToInt(String s) {
        int[] helper=new int[150];
        helper['I']=1;helper['V']=5;helper['X']=10;helper['L']=50;
        helper['C']=100;helper['D']=500;helper['M']=1000;
        int counter=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)!='I' && s.charAt(i)!='X' && s.charAt(i)!='C'){
                counter+=helper[s.charAt(i)];
            }else {
                if (i==s.length()-1){
                    counter+=helper[s.charAt(i)];
                    continue;
                }
                if (s.charAt(i)=='I' && (s.charAt(i+1)=='V' || s.charAt(i+1)=='X')){
                    counter--;
                }else if (s.charAt(i)=='X' && (s.charAt(i+1)=='L' || s.charAt(i+1)=='C')){
                    counter-=10;
                }else if (s.charAt(i)=='C' && (s.charAt(i+1)=='D' || s.charAt(i+1)=='M')){
                    counter-=100;
                }else {
                    counter+=helper[s.charAt(i)];
                }
            }
        }
        return counter;
    }
}
