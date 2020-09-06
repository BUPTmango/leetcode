package simple_level.jianzhi_offer;

/**
 * ������17. ��ӡ��1������nλ��
 * �������� n����˳���ӡ���� 1 ������ n λʮ���������������� 3�����ӡ�� 1��2��3 һֱ������ 3 λ�� 999��
 *
 * ʾ�� 1:
 *
 * ����: n = 1
 * ���: [1,2,3,4,5,6,7,8,9]
 * ?
 *
 * ˵����
 *
 * �÷���һ�������б��������ӡ
 * n Ϊ������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/26 8:04 ����
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        if (n < 1) {
            return null;
        }
        int length = (int) Math.pow(10, n) - 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            // ע�⣡������ ����ע�������Ĺ�ϵ ������0��ʼ Ҫ��λ��ֵ
            result[i] = i + 1;
        }
        return result;
    }
}
