package middle_level;

/**
 * 1314. ���������
 * ����һ��m * n�ľ���mat��һ������K �����㷵��һ������answer������ÿ��answer[i][j]��������������������Ԫ��mat[r][c] �ĺͣ�
 *
 * i - K <= r <= i + K, j - K <= c <= j + K
 * (r, c)�ھ����ڡ�
 * 
 *
 * ʾ�� 1��
 *
 * ���룺mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * �����[[12,21,16],[27,45,33],[24,39,28]]
 * ʾ�� 2��
 *
 * ���룺mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * �����[[45,45,45],[45,45,45],[45,45,45]]
 * 
 *
 * ��ʾ��
 *
 * m ==mat.length
 * n ==mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/23 9:45 ����
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        // dp[i][j]���ǣ�0 <= �� <= i�� 0 <= �� <= j)��Χ�ڵĺ�
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // ע�� i-k ֮��Ҫ�� -1
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
