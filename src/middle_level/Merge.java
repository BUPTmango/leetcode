package middle_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. �ϲ�����
 * ����һ������ļ��ϣ���ϲ������ص������䡣
 *
 * ʾ�� 1:
 *
 * ����: [[1,3],[2,6],[8,10],[15,18]]
 * ���: [[1,6],[8,10],[15,18]]
 * ����: ���� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
 * ʾ��?2:
 *
 * ����: [[1,4],[4,5]]
 * ���: [[1,5]]
 * ����: ���� [1,4] �� [4,5] �ɱ���Ϊ�ص����䡣
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/16 11:53 ����
 */
public class Merge {
    /**
     * ��������ֳ���������ֱ�����
     * ����ж��Ƿ�ɺϲ�
     * ���ɺϲ���������
     * �˴������ںϲ���j �ڵȴ���һ�룩�����ǵȴ��ɳɶԺ��ٺ��� list
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> list = new ArrayList<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                // ��һ�� start ���������޷����ǵ�ǰ end ������
                // ���ҵ� j ����һ�� i
                list.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
