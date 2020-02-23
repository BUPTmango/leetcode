package simple_level;

/**
 * 326
 * 3����
 * ����һ��������дһ���������ж����Ƿ��� 3?���ݴη���
 *
 * ʾ�� 1:
 *
 * ����: 27
 * ���: true
 * ʾ�� 2:
 *
 * ����: 0
 * ���: false
 * ʾ�� 3:
 *
 * ����: 9
 * ���: true
 * ʾ�� 4:
 *
 * ����: 45
 * ���: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/22 10:03 ����
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        // ����������־�Ҫ���Ƚ����жϣ��������Լ���ѭ���Ĵ���
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0 || n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsPowerOfThree is = new IsPowerOfThree();
        System.out.println(is.isPowerOfThree(27));
    }
}
