package middle_level;

/**
 * 322. ��Ǯ�һ�
 * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����?-1��
 *
 * ʾ��?1:
 *
 * ����: coins = [1, 2, 5], amount = 11
 * ���: 3
 * ����: 11 = 5 + 5 + 1
 * ʾ�� 2:
 *
 * ����: coins = [2], amount = 3
 * ���: -1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 1:53 ����
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // ��ʼ��Ϊ-1
        for (int m = 0; m < amount + 1; m++) {
            dp[m] = -1;
        }
        // 0��ʱ��Ϊ0
        dp[0] = 0;
        for (int v : coins) {
            for (int i = v; i <= amount; i++) {
                // ��һ��״̬�ǲ����ܣ�����ת��Ϊ����
                if (dp[i - v] == -1) {
                    continue;
                }
                // ��ǰ��һ�ּ���
                if (dp[i] == -1) {
                    dp[i] = dp[i - v] + 1;
                    continue;
                }
                // �����еļ�����ѡȡ��С��
                dp[i] = Math.min(dp[i], dp[i - v] + 1);
            }
        }
        return dp[amount];
    }
}
