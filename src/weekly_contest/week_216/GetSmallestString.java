package weekly_contest.week_216;

/**
 * 5606. ���и�����ֵ����С�ַ���
 * Сд�ַ� �� ��ֵ ��������ĸ���е�λ�ã��� 1 ��ʼ������� a ����ֵΪ 1 ��b ����ֵΪ 2 ��c ����ֵΪ 3 ���Դ����ơ�
 *
 * �ַ���������Сд�ַ���ɣ��ַ�������ֵ Ϊ���ַ�����ֵ֮�͡����磬�ַ��� "abe" ����ֵ���� 1 + 2 + 5 = 8 ��
 *
 * ������������ n �� k ������ ���� ���� n �� ��ֵ ���� k �� �ֵ�����С ���ַ�����
 *
 * ע�⣬����ַ��� x ���ֵ�������λ�� y ֮ǰ������Ϊ x �ֵ���� y С�����������������
 *
 * x �� y ��һ��ǰ׺��
 * ��� i �� x[i] != y[i] �ĵ�һ��λ�ã��� x[i] ����ĸ���е�λ�ñ� y[i] ��ǰ��
 *
 * ʾ�� 1��
 *
 * ���룺n = 3, k = 27
 * �����"aay"
 * ���ͣ��ַ�������ֵΪ 1 + 1 + 25 = 27��������ֵ����Ҫ���ҳ��ȵ��� 3 �ֵ�����С���ַ�����
 * ʾ�� 2��
 *
 * ���룺n = 5, k = 73
 * �����"aaszz"
 *
 * ��ʾ��
 *
 * 1 <= n <= 105
 * n <= k <= 26 * n
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/22 10:36 ����
 */
public class GetSmallestString {
    public String getSmallestString(int n, int k) {
        // ÿ��λ��������1 ���������ֵ25
        int total = k - n;
        // maxCountΪ�ճ�����25�ĸ���
        int maxCount = total / 25;
        // remainΪ��25֮��ʣ�µĸ���
        int remain = total % 25;
        // 1�ĸ���
        int oneCount = n - maxCount - 1;
        StringBuilder sb = new StringBuilder();
        while (oneCount-- > 0) {
            sb.append("a");
        }
        sb.append((char)('a' + remain));
        while (maxCount-- > 0) {
            sb.append("z");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GetSmallestString smallestString = new GetSmallestString();
        System.out.println(smallestString.getSmallestString(5, 73));
    }
}
