package middle_level;

/**
 * ��С����������
 * 712. �����ַ�������СASCIIɾ����
 * ���������ַ���s1, s2���ҵ�ʹ�����ַ����������ɾ���ַ���ASCIIֵ����С�͡�
 *
 * ʾ�� 1:
 *
 * ����: s1 = "sea", s2 = "eat"
 * ���: 231
 * ����: �� "sea" ��ɾ�� "s" ���� "s" ��ֵ(115)�����ܺ͡�
 * �� "eat" ��ɾ�� "t" ���� 116 �����ܺ͡�
 * ����ʱ�������ַ�����ȣ�115 + 116 = 231 ���Ƿ�����������С�͡�
 * ʾ��2:
 *
 * ����: s1 = "delete", s2 = "leet"
 * ���: 403
 * ����: �� "delete" ��ɾ�� "dee" �ַ������ "let"��
 * �� 100[d]+101[e]+101[e] �����ܺ͡��� "leet" ��ɾ�� "e" �� 101[e] �����ܺ͡�
 * ����ʱ�������ַ��������� "let"�������Ϊ 100+101+101+101 = 403 ��
 * �����Ϊ�������ַ���ת��Ϊ "lee" �� "eet"�����ǻ�õ� 433 �� 417 �Ľ�����ȴ𰸸���
 * ע��:
 *
 * 0 < s1.length, s2.length <= 1000��
 * �����ַ����е��ַ�ASCIIֵ��[97, 122]֮�䡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/29 10:08 ����
 */
public class MinimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // base case dp[0][0] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    // ����ԭ����+1�� ����Ҫ�ĳɼ����¼����ַ���ASC��
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int sum = 0;
        // ����������ַ����ܹ���ASC��
        for (char c1 : s1.toCharArray()) {
            sum += c1;
        }
        for (char c2 : s2.toCharArray()) {
            sum += c2;
        }
        return sum - 2 * dp[m][n];
    }
}
