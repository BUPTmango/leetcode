package hard_level;

/**
 * 1312. ���ַ�����Ϊ���Ĵ������ٲ������
 * ����һ���ַ���s��ÿһ�β����㶼�������ַ���������λ�ò��������ַ���
 *
 * ���㷵����s��Ϊ���Ĵ������ٲ���������
 *
 * �����Ĵ����������ͷ�������ͬ���ַ�����
 *
 * ʾ�� 1��
 *
 * ���룺s = "zzazz"
 * �����0
 * ���ͣ��ַ��� "zzazz" �Ѿ��ǻ��Ĵ��ˣ����Բ���Ҫ���κβ��������
 * ʾ�� 2��
 *
 * ���룺s = "mbadm"
 * �����2
 * ���ͣ��ַ����ɱ�Ϊ "mbdadbm" ���� "mdbabdm" ��
 * ʾ�� 3��
 *
 * ���룺s = "leetcode"
 * �����5
 * ���ͣ����� 5 ���ַ����ַ�����Ϊ "leetcodocteel" ��
 * ʾ�� 4��
 *
 * ���룺s = "g"
 * �����0
 * ʾ�� 5��
 *
 * ���룺s = "no"
 * �����1
 * 
 * ��ʾ��
 *
 * 1 <= s.length <= 500
 * s�������ַ�����Сд��ĸ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/10 10:19 ����
 */
public class MinInsertions {
    public int minInsertions(String s) {
        int n = s.length();
        // �����ַ���s[i..j]��������Ҫ����dp[i][j]�β�����ܱ���ַ���
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
