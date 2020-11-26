package weekly_contest.week_216;

import java.util.Arrays;

/**
 * 5608. ���������������ٳ�ʼ����
 * ����һ���������� tasks ������ tasks[i] = [actuali, minimumi] ��
 *
 * actuali ����ɵ� i ������ ��Ҫ�ķ� ��ʵ��������
 * minimumi �ǿ�ʼ�� i ������ǰ��Ҫ�ﵽ�����������
 * �ȷ�˵���������Ϊ [10, 12] ���㵱ǰ������Ϊ 11 ����ô�㲻�ܿ�ʼ�����������㵱ǰ������Ϊ 13 ��������������������������ʣ������Ϊ 3 ��
 *
 * ����԰��� ����˳�� �������
 *
 * ���㷵�������������� ���� ��ʼ������
 *
 * ʾ�� 1��
 *
 * ���룺tasks = [[1,2],[2,4],[4,8]]
 * �����8
 * ���ͣ�
 * һ��ʼ�� 8 ���������ǰ�������˳���������
 *     - ��ɵ� 3 ������ʣ������Ϊ 8 - 4 = 4 ��
 *     - ��ɵ� 2 ������ʣ������Ϊ 4 - 2 = 2 ��
 *     - ��ɵ� 1 ������ʣ������Ϊ 2 - 1 = 1 ��
 * ע�⵽��������������ʣ�࣬�������һ��ʼֻ�� 7 �����ǲ��������������ģ���Ϊ�����޷���ʼ�� 3 ������
 * ʾ�� 2��
 *
 * ���룺tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]
 * �����32
 * ���ͣ�
 * һ��ʼ�� 32 ���������ǰ�������˳���������
 *     - ��ɵ� 1 ������ʣ������Ϊ 32 - 1 = 31 ��
 *     - ��ɵ� 2 ������ʣ������Ϊ 31 - 2 = 29 ��
 *     - ��ɵ� 3 ������ʣ������Ϊ 29 - 10 = 19 ��
 *     - ��ɵ� 4 ������ʣ������Ϊ 19 - 10 = 9 ��
 *     - ��ɵ� 5 ������ʣ������Ϊ 9 - 8 = 1 ��
 * ʾ�� 3��
 *
 * ���룺tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]
 * �����27
 * ���ͣ�
 * һ��ʼ�� 27 ���������ǰ�������˳���������
 *     - ��ɵ� 5 ������ʣ������Ϊ 27 - 5 = 22 ��
 *     - ��ɵ� 2 ������ʣ������Ϊ 22 - 2 = 20 ��
 *     - ��ɵ� 3 ������ʣ������Ϊ 20 - 3 = 17 ��
 *     - ��ɵ� 1 ������ʣ������Ϊ 17 - 1 = 16 ��
 *     - ��ɵ� 4 ������ʣ������Ϊ 16 - 4 = 12 ��
 *     - ��ɵ� 6 ������ʣ������Ϊ 12 - 6 = 6 ��
 *
 * ��ʾ��
 *
 * 1 <= tasks.length <= 105
 * 1 <= actual?i <= minimumi <= 104
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/22 11:46 ����
 */
public class MinimumEffort {
    public int minimumEffort(int[][] tasks) {
        // ���� ������ ֮���յڶ�������
        Arrays.sort(tasks, (o1, o2) -> {
            int diff1 = o1[1] - o1[0];
            int diff2 = o2[1] - o2[0];
            if (diff1 == diff2) {
                return o2[1] - o1[1];
            } else {
                return diff2 - diff1;
            }
        });
        int res = 0;
        for (int i = 0; i < tasks.length - 1; i++) {
            res += tasks[i][0];
        }
        res += tasks[tasks.length - 1][1];

        int min = 0;
        for (int[] task : tasks) {
            min = Math.max(min, task[1]);
        }
        return Math.max(res, min);
    }

    public static void main(String[] args) {
        MinimumEffort effort = new MinimumEffort();
        System.out.println(effort.minimumEffort(new int[][]{{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}}));
    }
}