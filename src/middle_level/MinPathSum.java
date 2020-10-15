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
    /**
     * ��ĿҪ��ֻ�����һ������ߣ����仰˵����ǰ��Ԫ�� (i,j)(i,j) ֻ�ܴ��󷽵�Ԫ�� (i-1,j)(i?1,j) ���Ϸ���Ԫ�� (i,j-1)(i,j?1) �ߵ������ֻ��Ҫ���Ǿ�����߽���ϱ߽硣
     * <p>
     * �ߵ���ǰ��Ԫ�� (i,j)(i,j) ����С·���� == �����󷽵�Ԫ�� (i-1,j)(i?1,j) �� ���Ϸ���Ԫ�� (i,j-1)(i,j?1) ������ ������С·�����н�С�� �� ++ ��ǰ��Ԫ��ֵ grid[i][j]grid[i][j] �������Ϊ���� 4 �������
     * ����ߺ��ϱ߶����Ǿ���߽�ʱ�� ����i \not= 0i
     * ?
     * =0, j \not= 0j
     * ?
     * =0ʱ��dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]dp[i][j]=min(dp[i?1][j],dp[i][j?1])+grid[i][j] ��
     * ��ֻ������Ǿ���߽�ʱ�� ֻ�ܴ�������������i = 0, j \not= 0i=0,j
     * ?
     * =0ʱ�� dp[i][j] = dp[i][j - 1] + grid[i][j]dp[i][j]=dp[i][j?1]+grid[i][j] ��
     * ��ֻ���ϱ��Ǿ���߽�ʱ�� ֻ�ܴ�������������i \not= 0, j = 0i
     * ?
     * =0,j=0ʱ�� dp[i][j] = dp[i - 1][j] + grid[i][j]dp[i][j]=dp[i?1][j]+grid[i][j] ��
     * ����ߺ��ϱ߶��Ǿ���߽�ʱ�� ����i = 0, j = 0i=0,j=0ʱ����ʵ������㣬 dp[i][j] = grid[i][j]dp[i][j]=grid[i][j]��
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // ����߽���ϱ߽� Ҳ������� ֱ������
                if (i == 0 && j == 0) continue;
                    // �ϱ߽� ֻ���������ߵõ�
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                    // ��߽� ֻ���������ߵõ�
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                    // ���Ǳ߽� �����һ��������е���Сֵ�õ�
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        // �������½ǵ�ֵ �������·��
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum_another(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
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
