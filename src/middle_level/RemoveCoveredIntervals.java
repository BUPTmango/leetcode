package middle_level;

import java.util.Arrays;

/**
 * ��������
 * 1288. ɾ������������
 * ����һ�������б�����ɾ���б��б��������������ǵ����䡣
 *
 * ֻ�е�c <= a��b <= dʱ�����ǲ���Ϊ����[a,b) ������[c,d) ���ǡ�
 *
 * ���������ɾ�����������㷵���б���ʣ���������Ŀ��
 *
 * 
 *
 * ʾ����
 *
 * ���룺intervals = [[1,4],[3,6],[2,8]]
 * �����2
 * ���ͣ����� [3,6] ������ [2,8] ���ǣ���������ɾ���ˡ�
 * 
 *
 * ��ʾ��
 *
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] <intervals[i][1] <= 10^5
 * �������е�i != j��intervals[i] != intervals[j]
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 6:39 ����
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        // ��������������� �����ͬʱ��������
        // ��Ϊ�����ͬ��Ҫ��֤������������� ���Խ��������յ�
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        // ��¼�ϲ�����������յ�
        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // ���һ �ҵ���������
            if (left <= interval[0] && right >= interval[1]) {
                res++;
            }
            // ����� �ҵ��ཻ���� �ϲ�
            if (right >= interval[0] && right <= interval[1]) {
                right = interval[1];
            }
            // ����� ��ȫ���ཻ ���������յ�
            if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }

        return intervals.length - res;
    }
}
