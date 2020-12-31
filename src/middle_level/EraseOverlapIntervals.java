package middle_level;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ����ת�㷨������Ƶ���⡷̰���㷨 �� ��̬�滮������������У�
 * 435. ���ص�����
 * ����һ������ļ��ϣ��ҵ���Ҫ�Ƴ��������С������ʹʣ�����以���ص���
 *
 * ע��:
 *
 * ������Ϊ������յ����Ǵ���������㡣
 * ���� [1,2] �� [2,3] �ı߽��໥���Ӵ�������û���໥�ص���
 * ʾ�� 1:
 *
 * ����: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * ���: 1
 *
 * ����: �Ƴ� [1,3] ��ʣ�µ�����û���ص���
 * ʾ�� 2:
 *
 * ����: [ [1,2], [1,2], [1,2] ]
 *
 * ���: 2
 *
 * ����: ����Ҫ�Ƴ����� [1,2] ��ʹʣ�µ�����û���ص���
 * ʾ�� 3:
 *
 * ����: [ [1,2], [2,3] ]
 *
 * ���: 0
 *
 * ����: �㲻��Ҫ�Ƴ��κ����䣬��Ϊ�����Ѿ������ص����ˡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/20 9:06 ����
 */
public class EraseOverlapIntervals {
    /**
     * �����������
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // ����start�������У�start��ͬ����end��������
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        // dp[i] ��ʾ����[0,i]�������ص��������������
        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                // ǰһ����endС�ڵ��ڵ�ǰ��start��˵����������ص���+1
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return intervals.length - res;
    }

    /**
     * ̰���㷨
     * ��������Ľ�β����
     * ÿ��ѡ���β����ģ��Һ�ǰһ�����䲻�ص�������
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals_greedy(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // ��������Ľ�β����
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[1])));

        // ������һ�����䲻�ཻ
        int count = 1;
        // ����󣬵�һ���������x
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                // �ҵ���һ��ѡ���������
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
