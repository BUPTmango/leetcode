package middle_level;

/**
 * ����ת�㷨������Ƶ���⡷��̬�滮 ��������
 * 474. һ����
 * ����һ���������ַ������� strs ���������� m �� n ��
 * <p>
 * �����ҳ������� strs ������Ӽ��Ĵ�С�����Ӽ��� ��� �� m �� 0 �� n �� 1 ��
 * <p>
 * ��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ� ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * �����4
 * ���ͣ������ 5 �� 0 �� 3 �� 1 ������Ӽ��� {"10","0001","1","0"} ����˴��� 4 ��
 * �����������⵫��С���Ӽ����� {"0001","1"} �� {"10","1","0"} ��{"111001"} ���������⣬��Ϊ���� 4 �� 1 ������ n ��ֵ 3 ��
 * ʾ�� 2��
 * <p>
 * ���룺strs = ["10", "0", "1"], m = 1, n = 1
 * �����2
 * ���ͣ������Ӽ��� {"0", "1"} �����Դ��� 2 ��
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i]����'0' ��'1' ���
 * 1 <= m, n <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/20 8:48 ����
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = count(strs[i]);
            // ��ά���� ע�⣡������ Ҫ�Ӵ�С����
            for (int j = m; j >= count[0]; j--) {
                for (int k = n; k >= count[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - count[0]][k - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        char[] chars = str.toCharArray();
        int countZero = 0, countOne = 0;
        for (char c : chars) {
            if (c == '0') {
                countZero++;
            }
            if (c == '1') {
                countOne++;
            }
        }
        return new int[]{countZero, countOne};
    }
}
