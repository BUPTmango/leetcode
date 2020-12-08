package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮
 * 64. ��С·����
 * ����һ�������Ǹ������� m?x?n?�������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * <p>
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * [
 * ? [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * ���: 7
 * ����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/24 5:14 ����
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        // ��ʼ����߽�
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // ��ʼ���ϱ߽�
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
