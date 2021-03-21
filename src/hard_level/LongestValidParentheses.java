package hard_level;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/3/21 9:03 下午
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        // dp[i]表示以i结尾的最长有效括号的长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // 有效括号的最后一个字符肯定是右括号，所以遇到左括号不用管，遇到右括号才进行更新
            if (s.charAt(i) == ')') {
                // 前一个是左括号就直接配对
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    // 找到了前面的左括号
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
