package middle_level;

/**
 * 1314. 矩阵区域和
 * 给你一个m * n的矩阵mat和一个整数K ，请你返回一个矩阵answer，其中每个answer[i][j]是所有满足下述条件的元素mat[r][c] 的和：
 *
 * i - K <= r <= i + K, j - K <= c <= j + K
 * (r, c)在矩阵内。
 * 
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * 
 *
 * 提示：
 *
 * m ==mat.length
 * n ==mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/23 9:45 上午
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        // dp[i][j]就是（0 <= 行 <= i， 0 <= 列 <= j)范围内的和
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // 注意 i-k 之后还要再 -1
                int x0 = Math.max(i - K - 1, 0);
                int x1 = Math.min(i + K, row);
                int y0 = Math.max(j - K - 1, 0);
                int y1 = Math.min(j + K, col);
                res[i - 1][j - 1] = dp[x1][y1] - dp[x1][y0] - dp[x0][y1] + dp[x0][y0];
            }
        }
        return res;
    }
}
