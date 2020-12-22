package hard_level;

/**
 * ��ָ Offer 43. 1��n ������ 1 ���ֵĴ���
 * ����һ������ n ����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 * <p>
 * ���磬����12��1��12��Щ�����а���1 ��������1��10��11��12��1һ��������5�Ρ�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 12
 * �����5
 * ʾ�� 2��
 * <p>
 * ���룺n = 13
 * �����6
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= n <2^31
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/22 10:43 ����
 */
public class CountDigitOne {
    /**
     * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     * ����
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
