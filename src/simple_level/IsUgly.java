package simple_level;

/**
 * 263. ����
 * ��дһ�������жϸ��������Ƿ�Ϊ������
 * <p>
 * ��������ֻ����������?2, 3, 5?����������
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 6
 * ���: true
 * ����: 6 = 2 ��?3
 * ʾ�� 2:
 * <p>
 * ����: 8
 * ���: true
 * ����: 8 = 2 �� 2 ��?2
 * ʾ��?3:
 * <p>
 * ����: 14
 * ���: false
 * ����: 14 ���ǳ�������Ϊ������������һ��������?7��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/17 3:10 ����
 */
public class IsUgly {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;
        }
        return true;
    }
}
