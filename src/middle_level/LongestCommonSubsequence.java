package middle_level;

/**
 * 最长公共子序列
 * 《玩转算法面试视频例题》动态规划 最长公共子序列
 * 1143. 最长公共子序列
 * 给定两个字符串text1 和text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
 * 提示:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/21 8:50 下午
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // 对于text1[0..i - 1]和text2[0..j - 1] 他们的lcs长度是dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        // base case ： dp[0][0] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 获取两个串字符
                char c1 = text1.charAt(i - 1), c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
