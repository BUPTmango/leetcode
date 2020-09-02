package simple_level;

/**
 * 367. ��Ч����ȫƽ����
 * ����һ�������� num����дһ����������� num ��һ����ȫƽ�������򷵻� True�����򷵻� False��
 *
 * ˵������Ҫʹ���κ����õĿ⺯������? sqrt��
 *
 * ʾ�� 1��
 *
 * ���룺16
 * �����True
 * ʾ�� 2��
 *
 * ���룺14
 * �����False
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/2 1:30 ����
 */
public class IsPerfectSquare {
    /**
     * ���ֲ���
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
