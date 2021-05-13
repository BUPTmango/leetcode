package hard_level;

/**
 * 1269. 停在原地的方案数
 * 有一个长度为arrLen的数组，开始有一个指针在索引0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数steps 和arrLen ，请你计算并返回：在恰好执行steps次操作以后，指针仍然指向索引0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模10^9 + 7 后的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例 2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/13 16:34
 */
public class NumWays {
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        // 最多走steps步，并且走远了回不来，所以只需steps / 2 + 1
        int maxColumn = Math.min(arrLen - 1, steps / 2 + 1);
        // dp[i][j] 表示在 i 步操作之后，指针位于下标 j 的方案数
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                // 加上原地不动的方案数
                dp[i][j] = dp[i - 1][j];
                // 加上向左走的方案数
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                // 加上向右走的方案数
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }
}
