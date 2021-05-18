package middle_level;

/**
 * 1442. �γ������������������Ԫ����Ŀ
 * ����һ���������� arr ��
 *
 * ����Ҫ��������ȡ�����±� i��j �� k ������ (0 <= i < j <= k < arr.length) ��
 *
 * a �� b �������£�
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * ע�⣺^ ��ʾ ��λ��� ������
 *
 * �뷵���ܹ��� a == b ��������Ԫ�� (i, j , k) ����Ŀ��
 *
 * ʾ�� 1��
 *
 * ���룺arr = [2,3,1,6,7]
 * �����4
 * ���ͣ������������Ԫ��ֱ��� (0,1,2), (0,2,2), (2,3,4) �Լ� (2,4,4)
 * ʾ�� 2��
 *
 * ���룺arr = [1,1,1,1,1]
 * �����10
 * ʾ�� 3��
 *
 * ���룺arr = [2,3]
 * �����0
 * ʾ�� 4��
 *
 * ���룺arr = [1,3,5,7,9]
 * �����3
 * ʾ�� 5��
 *
 * ���룺arr = [7,11,12,9,5,2,7,17,22]
 * �����8
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/18 09:42
 */
public class CountTriplets {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        // ����ǰ׺���
        int[] s = new int[len + 1];
        for (int i = 0; i < len; i++) {
            s[i + 1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            for (int k = i + 1; k < len; ++k) {
                // ��s[i] == s[k + 1]����ʱ��[i+1,k] �ķ�Χ�ڵ����� j ���Ƿ���Ҫ��ģ���Ӧ����Ԫ�����Ϊ k-i��
                if (s[i] == s[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
