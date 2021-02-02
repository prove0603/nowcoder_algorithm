package leetcode.动态规划;

import java.util.List;

/**
 * @Date 2021/1/7 23:54
 * @Created by ZhuangJie
 * @Description 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class Question120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 1) {
            return triangle.get(0).get(0);
        }
        int dp[][] = new int[m + 1][m + 1];
        dp[1][1] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= i; j++) {
                if (j != 1 && j!=i) {
                    dp[i][j] = triangle.get(i - 1).get(j - 1) + Math.min(triangle.get(i - 2).get(j - 1), triangle.get(i - 2).get(j - 2));
                } else if (j!=1){
                    dp[i][j] = triangle.get(i - 1).get(j - 1) + triangle.get(i - 2).get(j - 1);
                }else {
                    dp[i][j] = triangle.get(i - 1).get(j - 1) + triangle.get(i - 2).get(j - 2);
                }
                if (i == m) {
                    if (dp[i][j]<min){
                        min=dp[i][j];
                    }
                }
            }
        }
        return min;
    }
}
