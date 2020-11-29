package simple_level;

import java.util.Arrays;

/**
 * 976. �����ε�����ܳ�
 * ������һЩ�����������ȣ���ɵ����� A����������������������ɵġ������Ϊ��������ε�����ܳ���
 *
 * ��������γ��κ������Ϊ��������Σ�����0��
 *
 * ʾ�� 1��
 *
 * ���룺[2,1,2]
 * �����5
 * ʾ�� 2��
 *
 * ���룺[1,2,1]
 * �����0
 * ʾ�� 3��
 *
 * ���룺[3,2,3,4]
 * �����10
 * ʾ�� 4��
 *
 * ���룺[3,6,2,3]
 * �����8
 * 
 * ��ʾ��
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/29 9:57 ����
 */
public class LargestPerimeter {
    /**
     * ̰�� + ����
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        // ÿ������Ϊ����� ���б���
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i - 2] + A[i - 1] + A[i];
            }
        }
        return 0;
    }
}
