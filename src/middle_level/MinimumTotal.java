package middle_level;

import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮
 * 120. ��������С·����
 * ����һ�������Σ��ҳ��Զ����µ���С·���͡�ÿһ��ֻ���ƶ�����һ�������ڵĽ���ϡ�
 * <p>
 * ���ڵĽ�� ������ָ���� �±� �� ��һ�����±� ��ͬ���ߵ��� ��һ�����±� + 1 ��������㡣
 * <p>
 * <p>
 * ���磬���������Σ�
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * �Զ����µ���С·����Ϊ11������2+3+5+1= 11����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 7:19 ����
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // �� f[i][j] ��ʾ�������ζ����ߵ�λ�� (i, j) ����С·����
        int[][] f = new int[n][n];
        // �����ʼֵ
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            // ÿһ������� ֻ����һ�е������Ч
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            // �Ƚ�j��j-1����Сֵ   ע�⣡���� ������j < i
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            // ÿһ�����Ҳ� ֻ����һ�е��Ҳ���Ч   ע�⣡���� �����������i
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        // �ҵ����һ���е���Сֵ
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
