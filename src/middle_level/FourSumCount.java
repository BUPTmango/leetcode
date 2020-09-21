package middle_level;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ת�㷨������Ƶ���⡷sum
 * 454. ������� II
 * �����ĸ����������������б�?A , B , C , D ,�����ж��ٸ�Ԫ�� (i, j, k, l)?��ʹ��?A[i] + B[j] + C[k] + D[l] = 0��
 * <p>
 * Ϊ��ʹ����򵥻������е� A, B, C, D ������ͬ�ĳ���?N���� 0 �� N �� 500 �����������ķ�Χ�� -228 �� 228 - 1 ֮�䣬���ս�����ᳬ��?231 - 1 ��
 * <p>
 * ����:
 * <p>
 * ����:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * ���:
 * 2
 * <p>
 * ����:
 * ����Ԫ������:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/21 6:45 ����
 */
public class FourSumCount {
    /**
     * ��һ��map�洢A��B�ĺ͵���������ĳ��ָ���
     * �����Խ�A+B�ĺ�C+D����������ŵ��������ұ��� ����Ҳ��O(n^2)��ʱ�临�Ӷ�
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[j];
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i] + D[j]);
                if (map.containsKey(sumCD)) {
                    res += map.get(sumCD);
                }
            }
        }
        return res;
    }
}
