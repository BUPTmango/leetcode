package middle_level.jianzhi_offer;

/**
 * ��ָ Offer 44. ����������ĳһλ������
 * ������0123456789101112131415���ĸ�ʽ���л���һ���ַ������С�����������У���5λ�����±�0��ʼ��������5����13λ��1����19λ��4���ȵȡ�
 *
 * ��дһ���������������nλ��Ӧ�����֡�
 *
 * ʾ�� 1��
 *
 * ���룺n = 3
 * �����3
 * ʾ�� 2��
 *
 * ���룺n = 11
 * �����0
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/31 9:22 ����
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        // 1. ȷ��������λ���������ֵ�λ��
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 2. ȷ��������λ���ڵ�����
        long num = start + (n - 1) / digit;
        // 3. ȷ��������λ�� numnum ����һ��λ
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
