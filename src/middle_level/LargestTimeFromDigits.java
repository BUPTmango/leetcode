package middle_level;

/**
 * 949. ������������ɵ����ʱ��
 * ����һ���� 4 λ������ɵ����飬���ؿ������õķ��� 24 Сʱ�Ƶ����ʱ�䡣
 * <p>
 * 24 Сʱ��ʽΪ "HH:MM" ������ HH �� 00 �� 23 ֮�䣬MM �� 00 �� 59 ֮�䡣��С�� 24 Сʱ��ʱ����00:00 ����������23:59 ���� 00:00 ����ҹ����ʼ���𣬹���Խ�ã�ʱ��Խ��
 * <p>
 * �Գ���Ϊ 5 ���ַ������� "HH:MM" ��ʽ���ش𰸡��������ȷ����Чʱ�䣬�򷵻ؿ��ַ�����
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [1,2,3,4]
 * �����"23:41"
 * ���ͣ���Ч�� 24 Сʱ��ʱ���� "12:34"��"12:43"��"13:24"��"13:42"��"14:23"��"14:32"��"21:34"��"21:43"��"23:14" �� "23:41" ����Щʱ���У�"23:41" �����ʱ�䡣
 * ʾ�� 2��
 * <p>
 * ���룺arr = [5,5,5,5]
 * �����""
 * ���ͣ���������Ч�� 24 Сʱ��ʱ�䣬��Ϊ "55:55" ��Ч��
 * ʾ�� 3��
 * <p>
 * ���룺arr = [0,0,0,0]
 * �����"00:00"
 * ʾ�� 4��
 * <p>
 * ���룺arr = [0,0,1,0]
 * �����"10:00"
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * arr.length == 4
 * 0 <= arr[i] <= 9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/9/2 21:37
 */
public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;

        // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j != i) {
                    for (int k = 0; k < 4; ++k) {
                        if (k != i && k != j) {
                            int l = 6 - i - j - k;

                            // For each permutation of A[i], read out the time and
                            // record the largest legal time.
                            int hours = 10 * A[i] + A[j];
                            int mins = 10 * A[k] + A[l];
                            if (hours < 24 && mins < 60) {
                                ans = Math.max(ans, hours * 60 + mins);
                            }
                        }
                    }
                }
            }
        }

        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
}
