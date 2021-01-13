package hard_level;

/**
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组nums中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得nums[left] * nums[i] * nums[right]个硬币。这里的left和right代表和i相邻的两个气球的序号。注意当你戳破了气球 i 后，气球left和气球right就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167 
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/13 4:37 下午
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 添加两侧的虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        // dp[i][j] = x 表示 戳破气球i和气球j之间（开区间）的所有气球 可以获得的最高分数x
        int[][] dp = new int[n + 2][n + 2];
        // base case 已经初始化为0
        // i == j的时候为0
        // 从下到上 从左到右
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                // 最后戳破的气球是哪个？遍历
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
