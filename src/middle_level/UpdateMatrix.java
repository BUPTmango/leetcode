package middle_level;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 ����
 * ����һ���� 0 �� 1 ��ɵľ����ҳ�ÿ��Ԫ�ص������ 0 �ľ��롣
 *
 * ��������Ԫ�ؼ�ľ���Ϊ 1 ��
 *
 * ʾ�� 1:
 * ����:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * ���:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * ʾ�� 2:
 * ����:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * ���:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * ע��:
 *
 * ���������Ԫ�ظ��������� 10000��
 * ����������������һ��Ԫ���� 0��
 * �����е�Ԫ��ֻ���ĸ�����������: �ϡ��¡����ҡ�
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/15 2:20 ����
 */
public class UpdateMatrix {
    /**
     * ���˵��"�����0�ľ���"�����·�����һ���뷨����BFS��
     * ��01����������Ԫ�صľ���0��λ�ã�Ԫ��0������ľ�����0��Ԫ��1��0�ľ������0��1�ľ��롣
     * ��һ����������¼ÿ��λ���Ƿ��Ѿ���������롣
     * ��ʼ��������Ͷ��У����������ҵ����е���0��λ�ã��������Ӧλ�ø�ֵ0����������ӡ�����������λ�ñ�ǡ�
     * ���ѣ�������Ԫ�س��Ӻ����ĸ�����ֱ�����һ��Ѱ��1(û�б���ǹ���λ�þ���1)���������λ�ô���1���¼���������Ϊ�����������Դ���ֵ+1��������ӡ���ǡ�
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];//�����
        boolean[][] visited = new boolean[m][n];//��¼�Ѿ��������λ��
        Queue<int[]> queue = new LinkedList<>();//���Ѷ���
        //������������0��λ�ü������������
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //�ĸ��������
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//��������
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            //�ĸ��������� 1
            for (int k = 0; k < 4; k++) {
                int di = i + direction[k][0], dj = j + direction[k][1];
                //û�м�����ĵط�һ���� 1
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]) {
                    res[di][dj] = res[i][j] + 1;
                    visited[di][dj] = true;
                    queue.offer(new int[]{di, dj});
                }
            }
        }
        return res;
    }
}
