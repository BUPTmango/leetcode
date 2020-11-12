package simple_level;

/**
 * 905. ����ż��������
 * ����һ���Ǹ��������� A������һ�����飬�ڸ������У�?A ������ż��Ԫ��֮�������������Ԫ�ء�
 * <p>
 * ����Է���������������κ�������Ϊ�𰸡�
 * <p>
 * ʾ����
 * <p>
 * ���룺[3,1,2,4]
 * �����[2,4,3,1]
 * ��� [4,2,3,1]��[2,4,1,3] �� [4,2,1,3] Ҳ�ᱻ���ܡ�
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/12 9:31 ����
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // ˫ָ��
        int fast = 0, slow = 0;
        // fast����һ��ż��
        while (fast < A.length) {
            if (A[fast] % 2 == 0) {
                swap(A, fast, slow);
                slow++;
            }
            fast++;
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
