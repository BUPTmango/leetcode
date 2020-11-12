package simple_level;

import java.util.*;

/**
 * 922. ����ż�������� II
 * ����һ���Ǹ���������A�� A ��һ��������������һ��������ż����
 * <p>
 * ��������������Ա㵱A[i] Ϊ����ʱ��iҲ����������A[i]Ϊż��ʱ�� i Ҳ��ż����
 * <p>
 * ����Է����κ���������������������Ϊ�𰸡�
 * <p>
 * ʾ����
 * <p>
 * ���룺[4,2,5,7]
 * �����[4,5,2,7]
 * ���ͣ�[4,7,2,5]��[2,5,4,7]��[2,7,4,5] Ҳ�ᱻ���ܡ�
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/12 8:40 ����
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        // ˫ָ�� ֻҪ��֤ż��λ������ż������ ʣ�µ�������Ȼ��������λ������
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            // ���A[i]Ϊ���� �Ͳ����ƶ�j ֱ��������һ��ż��
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        SortArrayByParityII s = new SortArrayByParityII();
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}
