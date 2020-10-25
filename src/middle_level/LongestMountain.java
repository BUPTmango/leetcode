package middle_level;

/**
 * 845. �����е��ɽ��
 * ���ǰ����� A �з����������Ե��������������� B ��Ϊ ��ɽ������
 * <p>
 * B.length >= 3
 * ���� 0 < i< B.length - 1 ʹ�� B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * ��ע�⣺B ������ A �����������飬������������ A����
 * <p>
 * ����һ���������� A������� ��ɽ�����ĳ��ȡ�
 * <p>
 * ��������� ��ɽ�����򷵻� 0��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[2,1,4,7,3,2,5]
 * �����5
 * ���ͣ���� ��ɽ���� �� [1,4,7,3,2]������Ϊ 5��
 * ʾ�� 2��
 * <p>
 * ���룺[2,2,2]
 * �����0
 * ���ͣ����� ��ɽ������
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/25 9:45 ����
 */
public class LongestMountain {
    /**
     * ö��ɽ��
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = A[i - 1] < A[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = A[i + 1] < A[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }
}
