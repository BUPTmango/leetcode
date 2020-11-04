package hard_level;

import java.util.ArrayList;
import java.util.List;

/**
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
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // �ڲ���������Ҳ����޽���
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // �ڲ��������������޽���
                ansList.add(interval);
            } else {
                // ����������н������������ǵĲ���
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
