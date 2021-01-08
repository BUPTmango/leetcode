package hard_level;

/**
 * �����������
 * 72. �༭����
 * ������������word1 ��word2������������word1ת����word2 ��ʹ�õ����ٲ�������
 *
 * ����Զ�һ�����ʽ����������ֲ�����
 *
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 * 
 *
 * ʾ��1��
 *
 * ���룺word1 = "horse", word2 = "ros"
 * �����3
 * ���ͣ�
 * horse -> rorse (�� 'h' �滻Ϊ 'r')
 * rorse -> rose (ɾ�� 'r')
 * rose -> ros (ɾ�� 'e')
 * ʾ��2��
 *
 * ���룺word1 = "intention", word2 = "execution"
 * �����5
 * ���ͣ�
 * intention -> inention (ɾ�� 't')
 * inention -> enention (�� 'i' �滻Ϊ 'e')
 * enention -> exention (�� 'n' �滻Ϊ 'x')
 * exention -> exection (�� 'n' �滻Ϊ 'c')
 * exection -> execution (���� 'u')
 * 
 *
 * ��ʾ��
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 �� word2 ��СдӢ����ĸ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/8 8:55 ����
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        // ���ֲ��� skip insert delete replace
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
