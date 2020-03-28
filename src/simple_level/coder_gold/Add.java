package simple_level.coder_gold;

/**
 * ������ 17.01. ���üӺŵļӷ�
 * ���һ������������������ӡ�����ʹ�� + �������������������
 *
 * ʾ��:
 *
 * ����: a = 1, b = 1
 * ���: 2
 * ?
 *
 * ��ʾ��
 *
 * a,?b?�������Ǹ����� 0
 * ���������� 32 λ����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/28 10:29 ����
 */
public class Add {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
}
