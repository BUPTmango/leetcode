package simple_level.jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * ������57 - II. ��Ϊs��������������
 * ����һ�������� target ��������к�Ϊ target ���������������У����ٺ�������������
 * <p>
 * �����ڵ�������С�������У���ͬ���а����׸����ִ�С�������С�
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺target = 9
 * �����[[2,3,4],[4,5]]
 * ʾ�� 2��
 * <p>
 * ���룺target = 15
 * �����[[1,2,3,4,5],[4,5,6],[7,8]]
 * ?
 * ���ƣ�
 * <p>
 * 1 <= target <= 10^5
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/2 11:33 ����
 */
public class FindContinuousSequence {
    /**
     * ����˫ָ�룬low = 1,high = 2;
     * sum��¼low ��high ֮���������ֵĺͣ�
     * �������Ƚ�sum �� target�Ĺ�ϵ��
     * ���sum�󣬾�˵����Ҫ��Сһ��ֵ�� ��ʱ����һ��low��
     * ���sumС��˵����Ҫ��������high�����뵽sum��
     * ���������ȣ��ͽ�low ��high֮����������ּ���һ�����飬��������������һ������
     * �����ʹ�� list.toArray() ����һ�����鼴��
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        // ��1��2��ʼ����
        int low = 1;
        int high = 2;
        // ����sum
        int sum = low + high;
        List<int[]> list = new ArrayList<>();
        while (low < high && high < target) {
            // sumС ����һ��ֵ ���high
            if (sum < target) {
                high++;
                sum += high;
                // sum�� ��Ҫ����һ��ֵ ����һ��low
            } else if (sum > target) {
                sum -= low;
                low++;
                // �ҵ��� ��low��high֮�������������ӵ��������
            } else {
                int[] sub = new int[high - low + 1];
                int j = low;
                for (int i = 0; i < high - low + 1; i++, j++) {
                    sub[i] = j;
                }
                list.add(sub);
                sum -= low;
                low++;
            }
        }
        int[][] out = new int[list.size()][];
        return list.toArray(out);
    }
}
