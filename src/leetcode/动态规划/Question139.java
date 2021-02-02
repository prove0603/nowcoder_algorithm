package leetcode.动态规划;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Date 2021/1/11 18:02
 * @Created by ZhuangJie
 * @Description
 * 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 */
public class Question139 {
    //题解的方法更简单   见最后
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        if (len==0) return false;
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        boolean dp[][]=new boolean[len+1][len+1];
        for (int j = 1; j <=len ; j++) {
            for (int i = 1; i <=j ; i++) {
                if (wordDict.contains(s.substring(i-1,j-1+1))){
                    dp[i][j]=true;
                }else {
                    for (String word:wordDict) {
                        if (j-word.length()+1>=1){
                            if (!dp[i][j] && wordDict.contains(s.substring(j-word.length()+1-1,j-1+1))){
                                dp[i][j]=dp[i][j-word.length()+1-1];
                                // break;
                            }
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return dp[1][len];
    }

    /**
     * public class Solution {
     *     public boolean wordBreak(String s, List<String> wordDict) {
     *         Set<String> wordDictSet = new HashSet(wordDict);
     *         boolean[] dp = new boolean[s.length() + 1];
     *         dp[0] = true;
     *         for (int i = 1; i <= s.length(); i++) {
     *             for (int j = 0; j < i; j++) {
     *                 if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
     *                     dp[i] = true;
     *                     break;
     *                 }
     *             }
     *         }
     *         return dp[s.length()];
     *     }
     * }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
