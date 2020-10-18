package simple_level;

/**
 * 1025. ��������
 * ����˿�ͱ���һ������Ϸ�����������ж�������˿���ֿ��֡�
 * <p>
 * ������ڰ�����һ������N����ÿ����ҵĻغϣ������Ҫִ�����²�����
 * <p>
 * ѡ����һx������0 < x < N ��N % x == 0��
 * �� N - x�滻�ڰ��ϵ����� N ��
 * �������޷�ִ����Щ�������ͻ������Ϸ��
 * <p>
 * ֻ���ڰ���˿����Ϸ��ȡ��ʤ��ʱ�ŷ���True�����򷵻� False������������Ҷ������״̬������Ϸ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺2
 * �����true
 * ���ͣ�����˿ѡ�� 1�������޷����в�����
 * ʾ�� 2��
 * <p>
 * ���룺3
 * �����false
 * ���ͣ�����˿ѡ�� 1������Ҳѡ�� 1��Ȼ����˿�޷����в�����
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= N <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/18 11:40 ����
 */
public class DivisorGame {
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }

        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            dp[i] = false;
            for (int j = 1; j < i; j++) {
                // j��i����������ʣ�µ�i-jҪ�ܻ�ʤ
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }
}
