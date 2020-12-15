package middle_level;

/**
 * 738. ��������������
 * ����һ���Ǹ�����N���ҳ�С�ڻ����N������������ͬʱ���������Ҫ���������λ���ϵ������ǵ���������
 *
 * �����ҽ���ÿ������λ���ϵ�����x��y����x <= yʱ�����ǳ���������ǵ��������ġ���
 *
 * ʾ�� 1:
 *
 * ����: N = 10
 * ���: 9
 * ʾ�� 2:
 *
 * ����: N = 1234
 * ���: 1234
 * ʾ�� 3:
 *
 * ����: N = 332
 * ���: 299
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/15 9:43 ����
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        // �ҵ���һ�����������
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            // �������ĵ��� ����Ѱ��
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            // �Ѻ���ı��9
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
