package 笔试真题.顺丰科技汇总;

import java.util.HashMap;

/**
 * @Date 2021/3/4 22:08
 * @Created by ZhuangJie
 * @Description
 *无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0) return 0;
        if(len==1) return 1;
        HashMap<Character,Integer> map=new HashMap();
        int max=0,left=0;
        for(int i=0;i<len;i++){
            if(map.containsKey(s.charAt(i))){
                left=Integer.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max=Integer.max(max, i-left+1);
        }
        return max;
    }
}
