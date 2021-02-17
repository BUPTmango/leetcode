package middle_level;

/**
 * ������֮������
 * <p>
 * 633. ƽ����֮��
 * ����һ���Ǹ�����c����Ҫ�ж��Ƿ������������ a �� b��ʹ��a2 + b2 = c ��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺c = 5
 * �����true
 * ���ͣ�1 * 1 + 2 * 2 = 5
 * ʾ�� 2��
 * <p>
 * ���룺c = 3
 * �����false
 * ʾ�� 3��
 * <p>
 * ���룺c = 4
 * �����true
 * ʾ�� 4��
 * <p>
 * ���룺c = 2
 * �����true
 * ʾ�� 5��
 * <p>
 * ���룺c = 1
 * �����true
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= c <= 231 - 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/2/17 9:31 ����
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
