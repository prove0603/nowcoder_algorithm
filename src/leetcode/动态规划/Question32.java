package leetcode.动态规划;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @Date 2021/1/4 22:21
 * @Created by ZhuangJie
 * @Description
 * 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class Question32 {
    /**
    如果遇到左括号我们就把他的下标压栈，如果遇到右括号说明和栈顶元素匹配，那么栈顶元素比如m出栈，
    用当前元素的下标减去新的栈顶元素的值，为什么减去新的栈顶元素值，这是因为新的栈顶元素还没匹配成功，
    之前的栈顶元素m到现在元素的下标之间构成了有效的括号
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 我们用dp[i]表示字符串前i个字符的最长有效括号。
     * 如果我们要想计算dp[i]就会有下面几种判断
     *
     * 第i个字符是左括号"("，那么以他结尾的是构不成有效括号的，所以dp[i]==0;
     * 第i个字符是右括号")"，那么以他结尾的是有可能构成有效括号的，所以还需要判断
     * 类似于这种……()，我们需要判断第i-1个字符是不是"("，如果是的话，那么最长有效括号就是第i-2个字符之前构成的最长有效括号+2，也就是dp[i]=dp[i-2]+2。
     * 类似于这种……((……))，我们看一下下面的图来看下，所以我们要判断第i -1- dp[i - 1]个字符是否是"(",如果是，那么递推公式是dp[i]=dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2],这里dp[i - dp[i - 1] - 2]是第一个省略号构成的有效括号，这个不要忘了
     *
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/javadai-ma-de-ji-chong-jie-fa-by-sdwwld/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int longestValidParentheses2(String s) {
        int max = 0;
        s = " " + s;
        int dp[] = new int[s.length()];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
