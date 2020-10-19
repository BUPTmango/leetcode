package middle_level;

import java.util.Arrays;

/**
 * 《玩转算法面试视频例题》动态规划 背包问题
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回?-1。
 * <p>
 * 示例?1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 1:53 下午
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // dp[i]为组成金额i最少的金币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 对于每个背包容量amount 都考虑了所有的硬币种类 所以满足了每种硬币可以无限次使用的条件
            for (int j = 0; j < coins.length; j++) {
                // 当前j硬币能放进容量为i的背包里
                if (coins[j] <= i) {
                    // 考虑不放和放j硬币两种情况
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
