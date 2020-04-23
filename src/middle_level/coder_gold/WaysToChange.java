package middle_level.coder_gold;

/**
 * 面试题 08.11. 硬币
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/23 12:25 下午
 */
public class WaysToChange {
    /**
     * 比如有1和3两种硬币凑7
     * 结果为能凑出7 - 1 = 6的个数加上能凑出7 - 3 = 4的个数
     * 转移方程 : dp[n] += dp[n - coins[i]]
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1]; // 初始化为0
        dp[0] = 1;
        int[] coins = new int[]{1, 5, 10, 25};
        // 遍历硬币的种类
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WaysToChange ways = new WaysToChange();
        System.out.println(ways.waysToChange(5));
    }
}