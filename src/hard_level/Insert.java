package hard_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��������
 * 57. ��������
 * ����һ�����ص��� ������������ʼ�˵�����������б�
 * <p>
 * ���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��
 * <p>
 * ʾ��1��
 * <p>
 * ���룺intervals = [[1,3],[6,9]], newInterval = [2,5]
 * �����[[1,5],[6,9]]
 * ʾ��2��
 * <p>
 * ���룺intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * �����[[1,2],[3,10],[12,16]]
 * ���ͣ�������Ϊ�µ����� [4,8] �� [3,5],[6,7],[8,10]�ص���
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/4 12:57 ����
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int index = 0;
        // ���������б�
        // 1 �����������������������������
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        // 2 �����жϵ�ǰ�����Ƿ����������ص� �ص��ͺϲ�
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[index++] = newInterval;
        // 3 ����������ұ�������������������
        while (i < intervals.length) {
            res[index++] = intervals[i++];
        }
        // ��Ϊ�ֿ������һ����[0,0] �ų��������
        return Arrays.copyOf(res, index);
    }
}
