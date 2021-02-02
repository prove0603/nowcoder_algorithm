package leetcode.动态规划;

/**
 * @Date 2021/1/7 1:25
 * @Created by ZhuangJie
 * @Description 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
 */
public class Question96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++)
            for (int j = 1; j < i + 1; j++)
                dp[i] += dp[j - 1] * dp[i - j];

        return dp[n];
    }
//    复杂度过高
//    public int numTrees(int n) {
//        if (n==0){
//            return 0;
//        }
//        return f(1,n);
//    }
//
//    public int f(int start,int end){
//        if (start>end){
//            return 0;
//        }
//        int counter=0;
//        for (int i = start; i <=end ; i++) {
//            int left=f(start,i-1)==0?1:f(start,i-1);
//            int right=f(i+1,end)==0?1:f(i+1,end);
//            counter+=left*right;
//        }
//        return counter;
//    }
}
