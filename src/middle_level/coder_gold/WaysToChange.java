package middle_level.coder_gold;

/**
 * ������ 08.11. Ӳ��
 * Ӳ�ҡ������������޵�Ӳ�ң���ֵΪ25�֡�10�֡�5�ֺ�1�֣���д�������n���м��ֱ�ʾ����(������ܻ�ܴ�����Ҫ�����ģ��1000000007)
 *
 * ʾ��1:
 *
 *  ����: n = 5
 *  �����2
 *  ����: �����ַ�ʽ���Դճ��ܽ��:
 * 5=5
 * 5=1+1+1+1+1
 * ʾ��2:
 *
 *  ����: n = 10
 *  �����4
 *  ����: �����ַ�ʽ���Դճ��ܽ��:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * ˵����
 *
 * ע��:
 *
 * ����Լ��裺
 *
 * 0 <= n (�ܽ��) <= 1000000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/23 12:25 ����
 */
public class WaysToChange {
    /**
     * ������1��3����Ӳ�Ҵ�7
     * ���Ϊ�ܴճ�7 - 1 = 6�ĸ��������ܴճ�7 - 3 = 4�ĸ���
     * ת�Ʒ��� : dp[n] += dp[n - coins[i]]
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1]; // ��ʼ��Ϊ0
        dp[0] = 1;
        int[] coins = new int[]{1, 5, 10, 25};
        // ����Ӳ�ҵ�����
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WaysToChange ways = new WaysToChange();
        System.out.println(ways.waysToChange(5));
    }
}