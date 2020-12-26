package hard_level;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. ������
 *
 * ��84��������
 *
 * ����һ��������0 �� 1 ����СΪ rows x cols �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ��������������
 *
 * 
 *
 * ʾ�� 1��
 *
 *
 * ���룺matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * �����6
 * ���ͣ�����������ͼ��ʾ��
 * ʾ�� 2��
 *
 * ���룺matrix = []
 * �����0
 * ʾ�� 3��
 *
 * ���룺matrix = [["0"]]
 * �����0
 * ʾ�� 4��
 *
 * ���룺matrix = [["1"]]
 * �����1
 * ʾ�� 5��
 *
 * ���룺matrix = [["0","0"]]
 * �����0
 * 
 * ��ʾ��
 *
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] Ϊ '0' �� '1'
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/26 2:51 ����
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[][] grid = new int[rows][cols];
        buildHistogram(matrix, grid);

        int max = 0;
        for (int i = 0; i < rows; i++) {
            // ����ӵ�һ�������ƶ�
            max = Math.max(max, maxRec(grid, i));
        }
        return max;
    }

    /** ����ֱ��ͼ */
    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int j = 0; j < matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // ��ǰλ���Ϊ1��++ �����0����0
                grid[i][j] = matrix[i][j] == '1' ? grid[i - 1][j] + 1 : 0;
            }
        }
    }

    /** ͬ84�� */
    private int maxRec(int[][] grid, int bottom) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // ��-1��ȥ �߽�����ô���
        stack.push(-1);
        int curIndex = 0;

        while (curIndex < grid[bottom].length) {
            // ������������ �Ͱ�ǰ����ó�����һ��max
            while (stack.peek() != -1 && grid[bottom][stack.peek()] >= grid[bottom][curIndex]) {
                max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
            }
            stack.push(curIndex++);
        }

        // ʣ�µ�ȫ���ǵ����� ����һ��max
        while (stack.peek() != -1) {
            max = Math.max(max, grid[bottom][stack.pop()] * (grid[bottom].length - stack.peek() - 1));
        }

        return max;
    }
}
