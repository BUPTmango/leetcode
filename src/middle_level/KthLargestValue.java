package middle_level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1738. �ҳ��� K ����������ֵ
 * <p>
 * ����һ����ά���� matrix ��һ������ k �������СΪm x n �ɷǸ�������ɡ�
 * <p>
 * ���������� (a, b) �� ֵ ���ɶ��������� 0 <= i <= a < m �� 0 <= j <= b < n ��Ԫ�� matrix[i][j]���±�� 0 ��ʼ������ִ���������õ���
 * <p>
 * �����ҳ�matrix �����������е� k ���ֵ��k ��ֵ�� 1 ��ʼ��������
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 1
 * �����7
 * ���ͣ����� (0,1) ��ֵ�� 5 XOR 2 = 7 ��Ϊ����ֵ��
 * ʾ�� 2��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 2
 * �����5
 * ���ͣ����� (0,0) ��ֵ�� 5 = 5 ��Ϊ�� 2 ���ֵ��
 * ʾ�� 3��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 3
 * �����4
 * ���ͣ����� (1,0) ��ֵ�� 5 XOR 1 = 4 ��Ϊ�� 3 ���ֵ��
 * ʾ�� 4��
 * <p>
 * ���룺matrix = [[5,2],[1,6]], k = 4
 * �����0
 * ���ͣ����� (1,1) ��ֵ�� 5 XOR 2 XOR 1 XOR 6 = 0 ��Ϊ�� 4 ���ֵ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/19 08:51
 */
public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        // ��άǰ׺��
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        List<Integer> results = new ArrayList<Integer>();
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                pre[i][j] = pre[i - 1][j] ^ pre[i][j - 1] ^ pre[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                results.add(pre[i][j]);
            }
        }

        Collections.sort(results, (num1, num2) -> num2 - num1);
        return results.get(k - 1);
    }
}
