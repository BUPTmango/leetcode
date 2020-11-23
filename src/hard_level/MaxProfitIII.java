package hard_level;

/**
 * 买卖股票
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 * <p>
 * 注意:你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/22 11:01 上午
 */
public class MaxProfitIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //进行初始化，第一天 s1 将股票买入，其他状态全部初始化为最小值
        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; ++i) {
            s1 = Math.max(s1, -prices[i]); //买入价格更低的股
            s2 = Math.max(s2, s1 + prices[i]); //卖出当前股，或者不操作
            s3 = Math.max(s3, s2 - prices[i]); //第二次买入，或者不操作
            s4 = Math.max(s4, s3 + prices[i]); //第二次卖出，或者不操作
        }
        return Math.max(0, s4);
    }

    public int maxProfit_state(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max_k = 2;
        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        // base case
        for (int k = 1; k <= max_k; k++) {
            dp[0][k][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
