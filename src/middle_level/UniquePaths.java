package middle_level;

/**
 * 《玩转算法面试视频例题》动态规划
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 *
 * 示例1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 * 
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/16 9:52 下午
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 先填充左边界和上边界
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 填充剩余部分
        for (int p = 1; p < m; p++) {
            for (int q = 1; q < n; q++) {
                dp[p][q] = dp[p - 1][q] + dp[p][q - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
