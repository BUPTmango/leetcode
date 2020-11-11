package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * 986. �����б�Ľ���
 * ����������һЩ ������ ��ɵ��б�ÿ�������б��ǳɶԲ��ཻ�ģ������Ѿ�����
 *
 * ���������������б�Ľ�����
 *
 * ����ʽ�ϣ�������[a, b]������a <= b����ʾʵ��x�ļ��ϣ���a <= x <= b������������Ľ�����һ��ʵ����ҪôΪ�ռ���ҪôΪ�����䡣���磬[1, 3] �� [2, 4] �Ľ���Ϊ [2, 3]����
 *
 * ʾ����
 *
 * ���룺A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * �����[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 
 *
 * ��ʾ��
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/11 7:20 ����
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // ˫ָ��
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();

        while (i < A.length && j < B.length) {
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            // ������������ཻ �Բ��ཻ�����ȡ�� a2 < b1 or b2 < a1
            if (b2 >= a1 && a2 >= b1) {
                list.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            // ָ��ǰ�� ȡ����a2��b2�Ĵ�С��ϵ
            if (b2 < a2) {
                j++;
            } else {
                i++;
            }
        }

        int[][] res = new int[list.size()][2];
        for (int m = 0; m < list.size(); m++) {
            res[m] = list.get(m);
        }
        return res;
    }
}
