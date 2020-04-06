package middle_level;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回?-1。
 *
 * 示例?1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 1:53 下午
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化为-1
        for (int m = 0; m < amount + 1; m++) {
            dp[m] = -1;
        }
        // 0的时候为0
        dp[0] = 0;
        for (int v : coins) {
            for (int i = v; i <= amount; i++) {
                // 上一个状态是不可能，不能转换为可能
                if (dp[i - v] == -1) {
                    continue;
                }
                // 当前的一种计数
                if (dp[i] == -1) {
                    dp[i] = dp[i - v] + 1;
                    continue;
                }
                // 在所有的计数中选取最小的
                dp[i] = Math.min(dp[i], dp[i - v] + 1);
            }
        }
        return dp[amount];
    }
}
