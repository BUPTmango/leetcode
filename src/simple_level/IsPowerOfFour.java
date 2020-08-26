package simple_level;

/**
 * 342. 4����
 * ����һ������ (32 λ�з�������)�����дһ���������ж����Ƿ��� 4?���ݴη���
 *
 * ʾ�� 1:
 *
 * ����: 16
 * ���: true
 * ʾ�� 2:
 *
 * ����: 5
 * ���: false
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/26 9:22 ����
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        // �������0 ������
        if (num == 0) {
            return false;
        }
        // һֱ����4 ֱ�����ܳ�Ϊֹ
        while (num % 4 == 0) {
            num /= 4;
        }
        // �������ǲ���1
        return num == 1;
    }
}
