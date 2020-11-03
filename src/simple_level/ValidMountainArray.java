package simple_level;

/**
 * 941. ��Ч��ɽ������
 * ����һ����������A�����������Ч��ɽ������ͷ���true�����򷵻� false��
 *
 * �����ǻع�һ�£���� A ����������������ô����һ��ɽ�����飺
 *
 * A.length >= 3
 * ��0 < i< A.length - 1�����£�����iʹ�ã�
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * ʾ�� 1��
 *
 * ���룺[2,1]
 * �����false
 * ʾ�� 2��
 *
 * ���룺[3,5,5]
 * �����false
 * ʾ�� 3��
 *
 * ���룺[0,3,2,1]
 * �����true
 *
 * ��ʾ��
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/3 11:02 ����
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // ����ɨ��
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // ��ߵ㲻��������ĵ�һ��λ�û����һ��λ��
        if (i == 0 || i == N - 1) {
            return false;
        }

        // �ݼ�ɨ��
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }

    public static void main(String[] args) {
        ValidMountainArray valid = new ValidMountainArray();
        System.out.println(valid.validMountainArray(new int[]{2, 0, 2}));
    }
}
