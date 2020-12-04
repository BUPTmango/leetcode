package middle_level;

/**
 * 718. ��ظ�������
 * ��������������A��B���������������й����ġ��������������ĳ��ȡ�
 *
 * ʾ����
 *
 * ���룺
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * �����3
 * ���ͣ�
 * ������Ĺ����������� [3, 2, 1] ��
 * 
 *
 * ��ʾ��
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/4 10:22 ����
 */
public class FindLength {
    /**
     * ��������
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        // B ���䣬A ����Ԫ���� B �е�ĳ��Ԫ�ض��� ֮�����Ѱ��
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        // A ���䣬B ����Ԫ���� A �е�ĳ��Ԫ�ض��� ֮�����Ѱ��
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    /** �Ƚ�����������ͬ�����������󳤶� */
    private int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

    /**
     * ��̬�滮
     * @param A
     * @param B
     * @return
     */
    public int findLength_dp(int[] A, int[] B) {
        int max = 0;
        int[] dp = new int[B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = B.length; j >= 1; j--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}
