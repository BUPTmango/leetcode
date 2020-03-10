package simple_level.jianzhi_offer;

/**
 * ������65. ���üӼ��˳����ӷ�
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ�� ��+������-������*������/�� ����������š�
 *
 * ʾ��:
 *
 * ����: a = 1, b = 1
 * ���: 2
 * ?
 * ��ʾ��
 *
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
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if(b == 0) {
            return a;        // when carry is zero, return
        }
        int sum = a ^ b;        // calculate sum without carry ��� ��һ��Ϊ1
        int carry = (a & b) << 1;       // calculate carry  �� ͬΪ1Ϊ1
        return add(sum, carry);
    }
}
