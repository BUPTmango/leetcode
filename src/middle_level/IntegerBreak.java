package middle_level;

import java.util.Arrays;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮
 * 343. �������
 * ����һ��������n��������Ϊ���������������ĺͣ���ʹ��Щ�����ĳ˻���󻯡� ��������Ի�õ����˻���
 *
 * ʾ�� 1:
 *
 * ����: 2
 * ���: 1
 * ����: 2 = 1 + 1, 1 �� 1 = 1��
 * ʾ��2:
 *
 * ����: 10
 * ���: 36
 * ����: 10 = 3 + 3 + 4, 3 ��3 ��4 = 36��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 9:01 ����
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        // dp[i]��ʾ������i�ָ��õ������˻�
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // j + (i - j)    (i - j)�����ֺͲ����������������
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
