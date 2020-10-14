package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ת�㷨������Ƶ���⡷ �������� �����㷨 ��άƽ�� floodfill
 * 417. ̫ƽ�������ˮ������
 * ����һ�� m x n �ķǸ�������������ʾһƬ��½�ϸ�����Ԫ��ĸ߶ȡ���̫ƽ�󡱴��ڴ�½����߽���ϱ߽磬���������󡱴��ڴ�½���ұ߽���±߽硣
 *
 * �涨ˮ��ֻ�ܰ����ϡ��¡������ĸ�������������ֻ�ܴӸߵ��ͻ�����ͬ�ȸ߶���������
 *
 * ���ҳ���Щˮ���ȿ�����������̫ƽ�󡱣������������������󡱵�½�ص�Ԫ�����ꡣ
 *
 *
 * ��ʾ��
 *
 * ��������˳����Ҫ
 * m �� n ��С��150
 *
 * ʾ����
 *
 * ��������� 5x5 ����:
 *
 *   ̫ƽ�� ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * ������
 *
 * ����:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (��ͼ�д����ŵĵ�Ԫ).
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/14 8:58 ����
 */
public class PacificAtlantic {

    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int m = 0;
    private int n = 0;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        // ��̫ƽ��ʹ�����ı߽�ͬʱ��
        for (int i = 0; i < m; i++) {
            floodFill(matrix, i, 0, pacific);
            floodFill(matrix, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            floodFill(matrix, 0, j, pacific);
            floodFill(matrix, m - 1, j, atlantic);
        }

        // �������Ҷ���1��λ��
        for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
                if (pacific[p][q] == 1 && atlantic[p][q] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(p);
                    list.add(q);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void floodFill(int[][] matrix, int i, int j, int[][] mark) {
        // ���0Ϊ1
        mark[i][j] = 1;
        // �����ĸ�����
        for (int[] direction : directions) {
            int di = i + direction[0];
            int dj = j + direction[1];
            if (inArea(matrix, i, j, di, dj, mark)) {
                floodFill(matrix, di, dj, mark);
            }
        }
    }

    private boolean inArea(int[][] matrix, int i, int j, int di, int dj, int[][] mark) {
        // ���·�����λ�ò���matrix��
        if (di < 0 || di >= m || dj < 0 || dj >= n) {
            return false;
        }
        // �Ѿ��߹�
        if (mark[di][dj] == 1) {
            return false;
        }
        // ����֮���ֵ>=����
        if (matrix[di][dj] < matrix[i][j]) {
            return false;
        }
        return true;
    }
}
