package middle_level.jianzhi_offer;

/**
 * 剑指 Offer II 092. 翻转字符
 * 如果一个由'0' 和 '1'组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * 我们给出一个由字符 '0' 和 '1'组成的字符串 s，我们可以将任何'0' 翻转为'1'或者将'1'翻转为'0'。
 * 返回使 s单调递增的最小翻转次数。
 *
 * 示例 1：
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入：s = "010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入：s = "00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 20000
 * s 中只包含字符'0'和'1'
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/2 14:40
 */
public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int numOfOne = (chars[0] == '1') ? 1 : 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (chars[i] == '1') {
                dp[i] = Math.min(dp[i - 1], numOfOne + 1);
                numOfOne++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, numOfOne);
            }
        }
        return dp[len - 1];
    }
}
