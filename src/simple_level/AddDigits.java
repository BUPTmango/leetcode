package simple_level;

/**
 * 258. ��λ���
 * ����һ���Ǹ����� num������������λ�ϵ�������ӣ�ֱ�����Ϊһλ����
 *
 * ʾ��:
 *
 * ����: 38
 * ���: 2
 * ����: ��λ��ӵĹ���Ϊ��3 + 8 = 11, 1 + 1 = 2�� ����?2 ��һλ�������Է��� 2��
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/8/17 2:02 ����
 */
public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int next = 0;
            while (num != 0) {
                next = next + num % 10;
                num /= 10;
            }
            num = next;
        }
        return num;
    }
}
