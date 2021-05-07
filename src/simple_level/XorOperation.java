package simple_level;

/**
 * 1486. ����������
 *
 * ��������������n �� start ��
 *
 * ���� nums ����Ϊ��nums[i] = start + 2*i���±�� 0 ��ʼ���� n == nums.length ��
 *
 * �뷵�� nums ������Ԫ�ذ�λ���XOR����õ��Ľ����
 *
 * ʾ�� 1��
 *
 * ���룺n = 5, start = 0
 * �����8
 * ���ͣ����� nums Ϊ [0, 2, 4, 6, 8]������ (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 ��
 *      "^" Ϊ��λ��� XOR �������
 * ʾ�� 2��
 *
 * ���룺n = 4, start = 3
 * �����8
 * ���ͣ����� nums Ϊ [3, 5, 7, 9]������ (3 ^ 5 ^ 7 ^ 9) = 8.
 * ʾ�� 3��
 *
 * ���룺n = 1, start = 7
 * �����7
 * ʾ�� 4��
 *
 * ���룺n = 10, start = 5
 * �����2
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/7 15:12
 */
public class XorOperation {
    public int xorOperation(int n, int start) {
        if (n == 1) {
            return start;
        }
        int[] nums = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }
}
