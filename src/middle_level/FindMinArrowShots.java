package middle_level;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. �����������ļ���������
 * �ڶ�ά�ռ�����������ε����򡣶���ÿ�������ṩ��������ˮƽ�����ϣ�����ֱ���Ŀ�ʼ�ͽ������ꡣ��������ˮƽ�ģ����������겢����Ҫ�����ֻҪ֪����ʼ�ͽ����ĺ�������㹻�ˡ���ʼ��������С�ڽ������ꡣ
 *
 * һ֧������������ x ��Ӳ�ͬ����ȫ��ֱ������������� x �����һ֧��������һ�������ֱ���Ŀ�ʼ�ͽ�������Ϊ xstart��xend�� ������ xstart�� x �� xend���������ᱻ��������������Ĺ���������û�����ơ� ����һ�������֮�󣬿������޵�ǰ�����������ҵ�ʹ����������ȫ��������������Ĺ�������С������
 *
 * ����һ������ points ������ points [i] = [xstart,xend] �������������������������������С��������
 *
 * ʾ�� 1��
 *
 * ���룺points = [[10,16],[2,8],[1,6],[7,12]]
 * �����2
 * ���ͣ����ڸ�������x = 6 �����䱬 [2,8],[1,6] ���������Լ� x = 11 �䱬������������
 * ʾ�� 2��
 *
 * ���룺points = [[1,2],[3,4],[5,6],[7,8]]
 * �����4
 * ʾ�� 3��
 *
 * ���룺points = [[1,2],[2,3],[3,4],[4,5]]
 * �����2
 * ʾ�� 4��
 *
 * ���룺points = [[1,2]]
 * �����1
 * ʾ�� 5��
 *
 * ���룺points = [[2,3],[2,3]]
 * �����1
 * 
 * ��ʾ��
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart <xend <= 231 - 1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/23 8:52 ����
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // ���������������
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int destination = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > destination) {
                res++;
                destination = point[1];
            } else {
                destination = Math.min(destination, point[1]);
            }
        }
        return res;
    }

    /**
     * ������ ����β������
     * @param points
     * @return
     */
    public int findMinArrowShots_better(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
