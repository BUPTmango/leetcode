package simple_level.jianzhi_offer;

/**
 * ������65. ���üӼ��˳����ӷ�
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ�� ��+������-������*������/�� ����������š�
 * <p>
 * ʾ��:
 * <p>
 * ����: a = 1, b = 1
 * ���: 2
 * ?
 * ��ʾ��
 * <p>
 * a,?b?�������Ǹ����� 0
 * ���������� 32 λ����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/10 11:07 ����
 */
public class Add {
    /**
     * a + b ��������Ϊ (a �� b ���޽�λ���) + (a �� b �Ľ�λ���)
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if (b == 0) {
            // when carry is zero, return
            return a;
        }
        // calculate sum without carry ��� ��һ��Ϊ1
        int sum = a ^ b;
        // calculate carry  �� ͬΪ1Ϊ1
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    public int add_iterate(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = 0, carry = 0;
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }
}

