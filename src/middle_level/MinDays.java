package middle_level;

/**
 * 1482. ���� m �����������������
 *
 * ��1011��ͬ ͨ�����ַ�
 * ��Ϊ���ص�������һ���ķ�Χ�����ǵ���������
 *
 * ����һ���������� bloomDay���Լ��������� m �� k ��
 * ����Ҫ���� m ��������������ʱ����Ҫʹ�û�԰�� ���ڵ� k �仨 ��
 * ��԰���� n �仨���� i �仨���� bloomDay[i] ʱʢ����ǡ�� �������� һ�� ���С�
 * ���㷵�شӻ�԰��ժ m ������Ҫ�ȴ������ٵ��������������ժ�� m �����򷵻� -1 ��
 *
 * ʾ�� 1��
 *
 * ���룺bloomDay = [1,10,3,10,2], m = 3, k = 1
 * �����3
 * ���ͣ�������һ��۲�������Ļ������̣�x ��ʾ�������� _ ��ʾ����δ����
 * ������Ҫ���� 3 ������ÿ��ֻ��Ҫ 1 �䡣
 * 1 ���[x, _, _, _, _]   // ֻ������ 1 ����
 * 2 ���[x, _, _, _, x]   // ֻ������ 2 ����
 * 3 ���[x, _, x, _, x]   // �������� 3 ��������Ϊ 3
 * ʾ�� 2��
 *
 * ���룺bloomDay = [1,10,3,10,2], m = 3, k = 2
 * �����-1
 * ���ͣ�Ҫ���� 3 ������ÿ����Ҫ 2 �仨��Ҳ����һ����Ҫ 6 �仨������԰��ֻ�� 5 �仨���޷���������Ҫ�󣬷��� -1 ��
 * ʾ�� 3��
 *
 * ���룺bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * �����12
 * ���ͣ�Ҫ���� 2 ������ÿ����Ҫ 3 �䡣
 * ��԰�� 7 ���� 12 ����������£�
 * 7 ���[x, x, x, x, _, x, x]
 * ������ǰ 3 ��ʢ���Ļ�������һ������������ʹ�ú� 3 ��ʢ���Ļ�����Ϊ���ǲ����ڡ�
 * 12 ���[x, x, x, x, x, x, x]
 * ��Ȼ�����ǿ����ò�ͬ�ķ�ʽ������������
 * ʾ�� 4��
 *
 * ���룺bloomDay = [1000000000,1000000000], m = 1, k = 1
 * �����1000000000
 * ���ͣ���Ҫ�� 1000000000 ����ܲɵ�������������
 * ʾ�� 5��
 *
 * ���룺bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * �����9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/5/10 09:05
 */
public class MinDays {
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) {
            return -1;
        }
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }
        right++;
        // Ѱ����߽�
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;
        int len = bloomDay.length;
        for (int i = 0; i < len; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
