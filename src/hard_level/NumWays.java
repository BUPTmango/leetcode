package hard_level;

/**
 * 1269. ͣ��ԭ�صķ�����
 * ��һ������ΪarrLen�����飬��ʼ��һ��ָ��������0 ����
 * ÿһ�������У�����Խ�ָ������������ƶ� 1 ��������ͣ��ԭ�أ�ָ�벻�ܱ��ƶ������鷶Χ�⣩��
 * ������������steps ��arrLen ��������㲢���أ���ǡ��ִ��steps�β����Ժ�ָ����Ȼָ������0 ���ķ�������
 * ���ڴ𰸿��ܻ�ܴ��뷵�ط����� ģ10^9 + 7 ��Ľ����
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺steps = 3, arrLen = 2
 * �����4
 * ���ͣ�3 �����ܹ��� 4 �ֲ�ͬ�ķ�������ͣ������ 0 ����
 * ���ң����󣬲���
 * ���������ң�����
 * ���ң�����������
 * ����������������
 * ʾ�� 2��
 * <p>
 * ���룺steps = 2, arrLen = 4
 * �����2
 * ���ͣ�2 �����ܹ��� 2 �ֲ�ͬ�ķ�������ͣ������ 0 ����
 * ���ң�����
 * ����������
 * ʾ�� 3��
 * <p>
 * ���룺steps = 4, arrLen = 2
 * �����8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/13 16:34
 */
public class NumWays {
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        // �����steps����������Զ�˻ز���������ֻ��steps / 2 + 1
        int maxColumn = Math.min(arrLen - 1, steps / 2 + 1);
        // dp[i][j] ��ʾ�� i ������֮��ָ��λ���±� j �ķ�����
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                // ����ԭ�ز����ķ�����
                dp[i][j] = dp[i - 1][j];
                // ���������ߵķ�����
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                // ���������ߵķ�����
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }
}
