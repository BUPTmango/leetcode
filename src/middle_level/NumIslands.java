package middle_level;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. ��������
 * ����һ����?'1'��½�أ��� '0'��ˮ����ɵĵĶ�ά����������������е����������
 *
 * �������Ǳ�ˮ��Χ������ÿ������ֻ����ˮƽ�����/����ֱ���������ڵ�½�������γɡ�
 *
 * ���⣬����Լ��������������߾���ˮ��Χ��
 *
 * ʾ�� 1:
 *
 * ����:
 * 11110
 * 11010
 * 11000
 * 00000
 * ���:?1
 * ʾ��?2:
 *
 * ����:
 * 11000
 * 11000
 * 00100
 * 00011
 * ���: 3
 * ����: ÿ������ֻ����ˮƽ��/����ֱ���������ڵ�½�����Ӷ��ɡ�
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/20 1:38 ����
 */
public class NumIslands {
    /**
     * ��������㷨
     * �ҵ�1�����ڵ�1�������Ǳ��0�����ҵ�������1
     * @param grid
     * @param r
     * @param c
     */
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0'; // ��ʾ��ǰ�Ѿ�������
        // �����ĸ�����
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    // �ҵ�1 ���в���
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    /**
     * �����������
     * �ҵ�1�Ž������У������õ�ǰΪ0
     * ֱ������Ϊ��
     * @param grid
     * @return
     */
    public int numIslands_another(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    // �ҵ�1�Ž�����
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        // �ҵ���Χ��1���Ž�����
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}
