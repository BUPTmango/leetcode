package middle_level;

/**
 * 516. �����������
 * ����һ���ַ��� s ���ҵ�������Ļ��������У������ظ����еĳ��ȡ����Լ��� s ����󳤶�Ϊ 1000 ��
 *
 * ʾ�� 1:
 * ����:
 *
 * "bbbab"
 * ���:
 *
 * 4
 * һ�����ܵ������������Ϊ "bbbb"��
 *
 * ʾ�� 2:
 * ����:
 *
 * "cbbd"
 * ���:
 *
 * 2
 * һ�����ܵ������������Ϊ "bb"��
 *
 * ��ʾ��
 *
 * 1 <= s.length <= 1000
 * s ֻ����СдӢ����ĸ
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/9 4:30 ����
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // ���Ӵ�s[i, j]�У�����������еĳ���Ϊdp[i][j]
        int[][] dp = new int[n][n];
        // base case [i, j] ��i��j��ȵ�ʱ��ֻ��һ���ַ����϶��ǻ��ĵģ����ҳ���Ϊ1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // i���� j����
        // ��ͼ����֪�����һ���Ѿ���base������ ���Դ� n - 2 ��ʼ
        for (int i = n - 2; i >= 0; i--) {
            // ��Ϊi�϶�<=j ���� i > j ��λ�� ������������ ����Ϊ0 ���ÿ���
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // ��������s���ȵĽ��
        return dp[0][n - 1];
    }
}
