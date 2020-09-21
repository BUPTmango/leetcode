package simple_level;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ת�㷨������Ƶ���⡷���ұ� �����ֵ
 * 447. �����ڵ�����
 * <p>
 * ����ƽ����n �Բ�ͬ�ĵ㣬�������ڡ� ���ɵ��ʾ��Ԫ��(i, j, k)������i��j֮��ľ����i��k֮��ľ�����ȣ���Ҫ����Ԫ���˳�򣩡�
 * <p>
 * �ҵ����л����ڵ�����������Լ���n ���Ϊ 500�����е�������ڱ����� [-10000, 10000] �С�
 * <p>
 * ʾ��:
 * <p>
 * ����:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * ���:
 * 2
 * <p>
 * ����:
 * ����������Ϊ [[1,0],[0,0],[2,0]] �� [[1,0],[2,0],[0,0]]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/21 8:39 ����
 */
public class NumberOfBoomerangs {
    /**
     * Ӧ�ò��ұ�
     * ͳ�ƾ���i����ͬ����ĵ��ж��ٸ�
     * ����������2*1 ����������3*2 ����ͬ����ϼ��㣩
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {

        int res = 0;

        // O(n^2)
        for (int i = 0; i < points.length; i++) {
            // �����������е㵽i�ľ���
            Map<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    record.put(distance(points[i], points[j]),
                            record.getOrDefault(distance(points[i], points[j]), 0) + 1);
                }
            }
            for (int k : record.values()) {
                res += k * (k - 1);
            }
        }
        return res;
    }

    private int distance(int[] x, int[] y) {
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }
}
