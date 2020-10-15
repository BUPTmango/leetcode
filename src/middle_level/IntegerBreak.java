package middle_level;

import java.util.Arrays;

/**
 * 《玩转算法面试视频例题》动态规划
 * 343. 整数拆分
 * 给定一个正整数n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 9:01 下午
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        // dp[i]表示将数字i分割后得到的最大乘积
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // j + (i - j)    (i - j)继续分和不继续分是两种情况
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
