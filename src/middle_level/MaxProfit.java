package middle_level;

/**
 * 买卖股票
 * 《玩转算法面试视频例题》动态规划
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。?
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/19 11:13 上午
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // 用 f[i] 表示第 i 天结束之后的「累计最大收益」  注意！！！ 是i天结束之后
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // i - 1天就已经持有的 或者 i天买入的
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            // i天卖出了 说明i-1天持有股票
            f[i][1] = f[i - 1][0] + prices[i];
            // 当天没有任何操作
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public int maxProfit_state(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // 分别代表dp[i][0], dp[i][1], dp[i - 2][0]
        int dp_i_0 = 0, dp_i_1 = -prices[0], dp_pre_0 = 0;
        for (int i = 1; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
