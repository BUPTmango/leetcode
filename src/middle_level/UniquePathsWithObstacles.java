package middle_level;


/**
 * ����ת�㷨������Ƶ���⡷��̬�滮
 * 63. ��ͬ·�� II
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����
 *
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������
 *
 * ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
 *
 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 *
 * ˵����m�� n ��ֵ�������� 100��
 *
 * ʾ��1:
 *
 * ����:
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * ���: 2
 * ����:
 * 3x3 ��������м���һ���ϰ��
 * �����Ͻǵ����½�һ���� 2 ����ͬ��·����
 * 1. ���� -> ���� -> ���� -> ����
 * 2. ���� -> ���� -> ���� -> ����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/16 10:06 ����
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        // �������߽���ϱ߽� ע�⣡������ ����0��ֹͣ�ˣ���Ϊû��·��������ȥ��
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        // ���ʣ�ಿ��
        for (int p = 1; p < m; p++) {
            for (int q = 1; q < n; q++) {
                if (obstacleGrid[p][q] == 0) {
                    dp[p][q] = dp[p - 1][q] + dp[p][q - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
