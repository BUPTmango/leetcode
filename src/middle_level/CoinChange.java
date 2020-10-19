package middle_level;

import java.util.Arrays;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮 ��������
 * 322. ��Ǯ�һ�
 * ������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ��������û���κ�һ��Ӳ�����������ܽ�����?-1��
 * <p>
 * ʾ��?1:
 * <p>
 * ����: coins = [1, 2, 5], amount = 11
 * ���: 3
 * ����: 11 = 5 + 5 + 1
 * ʾ�� 2:
 * <p>
 * ����: coins = [2], amount = 3
 * ���: -1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 1:53 ����
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // dp[i]Ϊ��ɽ��i���ٵĽ������
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // ����ÿ����������amount �����������е�Ӳ������ ����������ÿ��Ӳ�ҿ������޴�ʹ�õ�����
            for (int j = 0; j < coins.length; j++) {
                // ��ǰjӲ���ܷŽ�����Ϊi�ı�����
                if (coins[j] <= i) {
                    // ���ǲ��źͷ�jӲ���������
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
