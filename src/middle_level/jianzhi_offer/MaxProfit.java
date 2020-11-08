package middle_level.jianzhi_offer;

/**
 * 买卖股票
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/13 12:46 下午
 */
public class MaxProfit {
    /**
     * 前 ii 日最大利润 dp[i]dp[i] 等于前 i - 1i?1 日最大利润 dp[i-1]dp[i?1] 和第 ii 日卖出的最大利润中的最大值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            // 更新从开始到现在的最低价
            cost = Math.min(cost, price);
            // 取当天卖出的利润和之前的利润的最大值
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
