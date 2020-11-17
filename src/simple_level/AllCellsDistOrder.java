package simple_level;

import java.util.Arrays;

/**
 * 1030. ����˳�����о���Ԫ��
 * ���� R �� C �еľ������еĵ�Ԫ�����������Ϊ (r, c)������ 0 <= r < R �� 0 <= c < C��
 *
 * ���⣬�����ڸþ����и�����һ������Ϊ(r0, c0) �ĵ�Ԫ��
 *
 * ���ؾ����е����е�Ԫ������꣬������ (r0, c0) �ľ������С������˳���ţ����У�����Ԫ��(r1, c1) �� (r2, c2) ֮��ľ����������پ��룬|r1 - r2| + |c1 - c2|��������԰��κ������������˳�򷵻ش𰸡���
 *
 * ʾ�� 1��
 *
 * ���룺R = 1, C = 2, r0 = 0, c0 = 0
 * �����[[0,0],[0,1]]
 * ���ͣ��� (r0, c0) ��������Ԫ��ľ���Ϊ��[0,1]
 * ʾ�� 2��
 *
 * ���룺R = 2, C = 2, r0 = 0, c0 = 1
 * �����[[0,1],[0,0],[1,1],[1,0]]
 * ���ͣ��� (r0, c0) ��������Ԫ��ľ���Ϊ��[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] Ҳ�ᱻ������ȷ�𰸡�
 * ʾ�� 3��
 *
 * ���룺R = 2, C = 3, r0 = 1, c0 = 2
 * �����[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * ���ͣ��� (r0, c0) ��������Ԫ��ľ���Ϊ��[0,1,1,2,2,3]
 * ����������ĿҪ��Ĵ�Ҳ�ᱻ��Ϊ��ȷ������ [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]��
 * 
 * ��ʾ��
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/17 8:56 ����
 */
public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] cells = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cells[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(cells, (o1, o2) -> {
            int distance1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int distance2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return distance1 - distance2;
        });
        return cells;
    }


    public static void main(String[] args) {
        AllCellsDistOrder all = new AllCellsDistOrder();
        all.allCellsDistOrder(1,2,0,0);
    }
}
