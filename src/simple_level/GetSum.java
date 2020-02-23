package simple_level;

/**
 * 371
 * ������֮��
 * ��ʹ�������?+ ��?-????????������������????????a?��b????????֮�͡�
 *
 * ʾ�� 1:
 *
 * ����: a = 1, b = 2
 * ���: 3
 * ʾ�� 2:
 *
 * ����: a = -2, b = 3
 * ���: 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/20 10:59 ����
 */
public class GetSum {
    /**
     * a + b ��������Ϊ (a �� b ���޽�λ���) + (a �� b �Ľ�λ���)
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if(b == 0) {
            return a;        // when carry is zero, return
        }
        int sum = a ^ b;        // calculate sum without carry
        int carry = (a & b) << 1;       // calculate carry
        return getSum(sum, carry);
    }

}
