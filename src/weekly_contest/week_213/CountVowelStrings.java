package weekly_contest.week_213;

import java.util.Arrays;

/**
 * 5555. ͳ���ֵ���Ԫ���ַ�������Ŀ
 * ����һ������ n���뷵�س���Ϊ n ������Ԫ�� (a, e, i, o, u) ����Ұ� �ֵ������� ���ַ���������
 *
 * �ַ��� s �� �ֵ������� ��Ҫ���㣺����������Ч�� i��s[i] ����ĸ���е�λ�������� s[i+1] ��ͬ���� s[i+1] ֮ǰ��
 *
 * ʾ�� 1��
 *
 * ���룺n = 1
 * �����5
 * ���ͣ�����Ԫ����ɵ� 5 ���ֵ����ַ���Ϊ ["a","e","i","o","u"]
 * ʾ�� 2��
 *
 * ���룺n = 2
 * �����15
 * ���ͣ�����Ԫ����ɵ� 15 ���ֵ����ַ���Ϊ
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * ע�⣬"ea" ���Ƿ���������ַ�������Ϊ 'e' ����ĸ���е�λ�ñ� 'a' ����
 * ʾ�� 3��
 *
 * ���룺n = 33
 * �����66045
 *
 * ��ʾ��
 *
 * 1 <= n <= 50
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/1 11:10 ����
 */
public class CountVowelStrings {
    public int countVowelStrings(int n) {
        int[] times = new int[5];
        Arrays.fill(times, 1);

        while (n-- > 1) {
            for (int i = 1; i < 5; i++) {
                times[i] += times[i - 1];
            }
        }

        return sumArray(times);
    }

    private int sumArray(int[] array) {
        int sum = 0;
        for (int a : array) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountVowelStrings count = new CountVowelStrings();
        System.out.println(count.countVowelStrings(33));
    }
}
