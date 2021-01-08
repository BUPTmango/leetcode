package middle_level;

/**
 * �����������
 * ����ת�㷨������Ƶ���⡷��̬�滮 �����������
 * 1143. �����������
 * ���������ַ���text1 ��text2�������������ַ���������������еĳ��ȡ�
 * <p>
 * һ���ַ�������������ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С������ַ����ġ����������С����������ַ�������ͬӵ�е������С�
 * <p>
 * ���������ַ���û�й��������У��򷵻� 0��
 * <p>
 * ʾ�� 1:
 * <p>
 * ���룺text1 = "abcde", text2 = "ace"
 * �����3
 * ���ͣ�������������� "ace"�����ĳ���Ϊ 3��
 * ʾ�� 2:
 * <p>
 * ���룺text1 = "abc", text2 = "abc"
 * �����3
 * ���ͣ�������������� "abc"�����ĳ���Ϊ 3��
 * ʾ�� 3:
 * <p>
 * ���룺text1 = "abc", text2 = "def"
 * �����0
 * ���ͣ������ַ���û�й��������У����� 0��
 * <p>
 * ��ʾ:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * ������ַ���ֻ����СдӢ���ַ���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/21 8:50 ����
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        // ����text1[0..i - 1]��text2[0..j - 1] ���ǵ�lcs������dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        // base case �� dp[0][0] = 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // ��ȡ�������ַ�
                char c1 = text1.charAt(i - 1), c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    // ȥ������ǰ�����һ���ֵ��1����
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Ҫô��text1��ǰ��һ��Ҫô��text2��ǰ��һ�����������ֵ
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
