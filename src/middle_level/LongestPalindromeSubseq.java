package middle_level;

/**
 * 516. 最长回文子序列
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/9 4:30 下午
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // 在子串s[i, j]中，最长回文子序列的长度为dp[i][j]
        int[][] dp = new int[n][n];
        // base case [i, j] 当i和j相等的时候只有一个字符，肯定是回文的，并且长度为1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // i反向 j正向
        // 画图可以知道最后一排已经被base填满了 所以从 n - 2 开始
        for (int i = n - 2; i >= 0; i--) {
            // 因为i肯定<=j 所以 i > j 的位置 不存在子序列 所以为0 不用考虑
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 返回整个s长度的结果
        return dp[0][n - 1];
    }
}
