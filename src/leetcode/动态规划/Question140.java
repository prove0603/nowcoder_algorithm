package leetcode.动态规划;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Date 2021/1/12 15:29
 * @Created by ZhuangJie
 * @Description 单词拆分 II
 * https://leetcode-cn.com/problems/word-break-ii/
 * https://leetcode-cn.com/problems/word-break-ii/solution/dong-tai-gui-hua-hui-su-qiu-jie-ju-ti-zhi-python-d/
 */

public class Question140 {

    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = wordDict.size();
        result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (dp[len]){
            f(0, s, hashSet, new ArrayList<String>());
        }
        return result;
    }

    public void f(int start, String s, HashSet<String> hashSet, ArrayList<String> list) {
        if (start == s.length()) {
            String str = String.join(" ", list);
            if (str.length() == s.length() + list.size() - 1) {
                result.add(str);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String tmp = s.substring(start, i + 1);
            if (hashSet.contains(tmp)) {
                list.add(s.substring(start, i + 1));
                f(i + 1, s, hashSet, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
