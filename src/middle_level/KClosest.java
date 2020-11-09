package middle_level;

import java.util.*;

/**
 * 973. ��ӽ�ԭ��� K ����
 * ������һ����ƽ���ϵĵ���ɵ��б� points����Ҫ�����ҳ� K ������ԭ�� (0, 0) ����ĵ㡣
 *
 * �����ƽ��������֮��ľ�����ŷ����¾��롣��
 *
 * ����԰��κ�˳�򷵻ش𰸡����˵������˳��֮�⣬��ȷ����Ψһ�ġ�
 *
 * ʾ�� 1��
 *
 * ���룺points = [[1,3],[-2,2]], K = 1
 * �����[[-2,2]]
 * ���ͣ�
 * (1, 3) ��ԭ��֮��ľ���Ϊ sqrt(10)��
 * (-2, 2) ��ԭ��֮��ľ���Ϊ sqrt(8)��
 * ���� sqrt(8) < sqrt(10)��(-2, 2) ��ԭ�������
 * ����ֻ��Ҫ����ԭ������� K = 1 ���㣬���Դ𰸾��� [[-2,2]]��
 * ʾ�� 2��
 *
 * ���룺points = [[3,3],[5,-1],[-2,4]], K = 2
 * �����[[3,3],[-2,4]]
 * ���� [[-2,4],[3,3]] Ҳ�ᱻ���ܡ���
 *
 * ��ʾ��
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/9 8:59 ����
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        // ����һ�����ȶ��� ע�������ǽ���
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> {
            int distance1 = o1[0] * o1[0] + o1[1] * o1[1];
            int distance2 = o2[0] * o2[0] + o2[1] * o2[1];
            return distance2 - distance1;
        });

        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int[][] res = new int[heap.size()][2];
        int index = 0;
        while (!heap.isEmpty()) {
            res[index] = heap.poll();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        KClosest k = new KClosest();
        int[][] points = new int[][]{{1,3}, {-2,2}};
        int K = 1;
        int[][] res = k.kClosest(points, K);
        Arrays.stream(res).forEach(System.out::println);
    }
}
