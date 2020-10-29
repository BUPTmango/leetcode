package middle_level;

/**
 * �����������
 * 583. �����ַ�����ɾ������
 * ������������word1��word2���ҵ�ʹ��word1��word2��ͬ�������С������ÿ������ɾ������һ���ַ����е�һ���ַ���
 *
 * 
 *
 * ʾ����
 *
 * ����: "sea", "eat"
 * ���: 2
 * ����: ��һ����"sea"��Ϊ"ea"���ڶ�����"eat"��Ϊ"ea"
 * 
 *
 * ��ʾ��
 *
 * �������ʵĳ��Ȳ�����500��
 * ���������е��ַ�ֻ����Сд��ĸ��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/29 9:58 ����
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        // �ҵ�������ִ�����֮�� ���������ʵĳ��ȼ�ȥ�����ִ����ȵĶ��� ���Ǵ�
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case dp[0][0] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i - 1);
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    // ����������ִ���
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
