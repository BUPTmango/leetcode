package hard_level;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 * 给你一个字符串s，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让s成为回文串的最少操作次数。
 *
 * 「回文串」是正读和反读都相同的字符串。
 *
 * 示例 1：
 *
 * 输入：s = "zzazz"
 * 输出：0
 * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
 * 示例 2：
 *
 * 输入：s = "mbadm"
 * 输出：2
 * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
 * 示例 3：
 *
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 * 示例 4：
 *
 * 输入：s = "g"
 * 输出：0
 * 示例 5：
 *
 * 输入：s = "no"
 * 输出：1
 * 
 * 提示：
 *
 * 1 <= s.length <= 500
 * s中所有字符都是小写字母。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/10 10:19 下午
 */
public class MinInsertions {
    public int minInsertions(String s) {
        int n = s.length();
        // 对于字符串s[i..j]，最少需要进行dp[i][j]次插入才能变成字符串
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
