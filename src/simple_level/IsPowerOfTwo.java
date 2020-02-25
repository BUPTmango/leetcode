package simple_level;

/**
 * 231
 * 2����
 * ����һ����������дһ���������ж����Ƿ��� 2 ���ݴη���
 *
 * ʾ��?1:
 *
 * ����: 1
 * ���: true
 * ����: 20?= 1
 * ʾ�� 2:
 *
 * ����: 16
 * ���: true
 * ����: 24?= 16
 * ʾ�� 3:
 *
 * ����: 218
 * ���: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/25 10:19 ����
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int remainder = 0;
        while (n > 1) {
            remainder = n % 2;
            if (remainder != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}
