package weekly_contest.week_217;

/**
 * 5613. ��пͻ����ʲ�����
 * ����һ�� m x n ���������� accounts ������ accounts[i][j] �ǵ� i???????????? λ�ͻ��ڵ� j �������йܵ��ʲ�������������пͻ���ӵ�е� �ʲ����� ��
 *
 * �ͻ��� �ʲ����� ���������ڸ��������йܵ��ʲ�����֮�͡���пͻ����� �ʲ����� ���Ŀͻ���
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺accounts = [[1,2,3],[3,2,1]]
 * �����6
 * ���ͣ�
 * �� 1 λ�ͻ����ʲ����� = 1 + 2 + 3 = 6
 * �� 2 λ�ͻ����ʲ����� = 3 + 2 + 1 = 6
 * ��λ�ͻ�������еģ��ʲ��������� 6 �����Է��� 6 ��
 * ʾ�� 2��
 *
 * ���룺accounts = [[1,5],[7,3],[3,5]]
 * �����10
 * ���ͣ�
 * �� 1 λ�ͻ����ʲ����� = 6
 * �� 2 λ�ͻ����ʲ����� = 10
 * �� 3 λ�ͻ����ʲ����� = 8
 * �� 2 λ�ͻ�����еģ��ʲ������� 10
 * ʾ�� 3��
 *
 * ���룺accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * �����17
 *
 * ��ʾ��
 *
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/29 10:32 ����
 */
public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
