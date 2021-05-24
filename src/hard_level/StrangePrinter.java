package hard_level;

/**
 * 664. ��ֵĴ�ӡ��
 * ��̨��ֵĴ�ӡ����������������Ҫ��
 *
 * ��ӡ��ÿ��ֻ�ܴ�ӡ�� ͬһ���ַ� ��ɵ����С�
 * ÿ�ο�����������ʼ�ͽ���λ�ô�ӡ���ַ������һḲ�ǵ�ԭ�����е��ַ���
 * ����һ���ַ��� s ����������Ǽ��������ӡ����ӡ����Ҫ�����ٴ�ӡ������
 *
 * ʾ�� 1��
 *
 * ���룺s = "aaabbb"
 * �����2
 * ���ͣ����ȴ�ӡ "aaa" Ȼ���ӡ "bbb"��
 * ʾ�� 2��
 *
 * ���룺s = "aba"
 * �����2
 * ���ͣ����ȴ�ӡ "aaa" Ȼ���ڵڶ���λ�ô�ӡ "b" ���ǵ�ԭ�����ַ� 'a'��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/24 09:06
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                // ��ȵ�ʱ���ӡi��ʱ��ͽ�j��ӡ�ˣ��Ͳ��ÿ���j�ˣ�ֻ��Ҫ����j֮ǰ��
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // ��k�ָ���ҷֱ��ӡ��ȡ��Сֵ
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][len - 1];
    }
}
