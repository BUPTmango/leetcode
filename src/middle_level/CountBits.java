package middle_level;

/**
 * 338. ����λ����
 * ����һ���Ǹ�����?num������?0 �� i �� num ��Χ�е�ÿ������?i?����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 *
 * ʾ�� 1:
 *
 * ����: 2
 * ���: [0,1,1]
 * ʾ��?2:
 *
 * ����: 5
 * ���: [0,1,1,2,1,2]
 * ����:
 *
 * ����ʱ�临�Ӷ�ΪO(n*sizeof(integer))�Ľ��ǳ����ס��������������ʱ��O(n)����һ��ɨ��������
 * Ҫ���㷨�Ŀռ临�Ӷ�ΪO(n)��
 * ���ܽ�һ�����ƽⷨ��Ҫ����C++���κ����������в�ʹ���κ����ú������� C++ �е�?__builtin_popcount����ִ�д˲�����
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/14 12:28 ����
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            ans[i] = popcount(i);
        }
        return ans;
    }
    private int popcount(int x) {
        int count;
        for (count = 0; x != 0; ++count) {
            // �������ܽ����һλ���0
            x &= x - 1; //zeroing out the least significant nonzero bit
        }
        return count;
    }
}
