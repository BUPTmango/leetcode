package hard_level;

/**
 * 879. ӯ���ƻ�
 * �������� n ��Ա�������ǿ�����ɸ��ָ����Ĺ�����������
 * <p>
 * ��i�ֹ��������profit[i]��������Ҫ��group[i]����Ա��ͬ���롣�����Ա����������һ������Ͳ��ܲ�����һ�����
 * <p>
 * �������κ����ٲ���minProfit ������Ӽ���Ϊ ӯ���ƻ� �����ҹ����ĳ�Ա�������Ϊ n ��
 * <p>
 * �ж����ּƻ�����ѡ����Ϊ�𰸺ܴ����� ���ؽ��ģ10^9 + 7��ֵ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * �����2
 * ���ͣ����ٲ��� 3 �����󣬸ü��ſ�����ɹ��� 0 �͹��� 1 �������ɹ��� 1 ��
 * �ܵ���˵�������ּƻ���
 * ʾ�� 2��
 * <p>
 * ���룺n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * �����7
 * ���ͣ����ٲ��� 5 ������ֻҪ�������һ�ֹ������У����Ըü��ſ�������κι�����
 * �� 7 �ֿ��ܵļƻ���(0)��(1)��(2)��(0,1)��(0,2)��(1,2)���Լ� (0,1,2) ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/6/9 09:26
 */
public class ProfitableSchemes {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // ���ر���
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        int len = group.length, MOD = (int) 1e9 + 7;
        for (int i = 1; i <= len; i++) {
            int members = group[i - 1], earn = profit[i - 1];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}
