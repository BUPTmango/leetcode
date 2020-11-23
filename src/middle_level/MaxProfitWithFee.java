package middle_level;

/**
 * 买卖股票
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/22 11:20 上午
 */
public class MaxProfitWithFee {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i]为第i天结束时的最大收益
        int[][] f = new int[n][2];
        // f[i][0]代表i天结束之后不持有股票的最大收益
        f[0][0] = 0;
        // f[i][1]代表i天结束之后持有股票的最大收益
        f[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i] - fee);
            f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]);
        }
        return f[n - 1][0];
    }

    /**
     * 状态转移方法
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit_state(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // base case
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            int tmp = dp_i_0;
            // i表示i天结束之后
            // 0表示不持有股票 1表示持有股票
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
