package middle_level.jianzhi_offer;

/**
 * ��ָ Offer 43. 1��n������1���ֵĴ���
 * ����һ������ n ����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 *
 * ���磬����12��1��12��Щ�����а���1 ��������1��10��11��12��1һ��������5�Ρ�
 *
 * ʾ�� 1��
 *
 * ���룺n = 12
 * �����5
 * ʾ�� 2��
 *
 * ���룺n = 13
 * �����6
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/28 10:53 ����
 */
public class CountDigitOne {
    /**
     * while high != 0 or cur != 0: # �� high �� cur ͬʱΪ 0 ʱ��˵���Ѿ�Խ�����λ���������
     *    low += cur * digit # �� cur ���� low ��������� low
     *    cur = high % 10 # ���� cur �Ǳ��� high �����λ
     *    high //= 10 # ������ high ���λɾ�����õ����� high
     *    digit *= 10 # λ����ÿ�� �� 10
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while(high != 0 || cur != 0) {
            if(cur == 0) {
                res += high * digit;
            } else if(cur == 1) {
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
