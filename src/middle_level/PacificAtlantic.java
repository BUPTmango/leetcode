package middle_level;

import java.util.ArrayList;
import java.util.List;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 二维平面 floodfill
 * 417. 太平洋大西洋水流问题
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *
 * 示例：
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/14 8:58 上午
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
        // 从太平洋和大西洋的边界同时走
        for (int i = 0; i < m; i++) {
            floodFill(matrix, i, 0, pacific);
            floodFill(matrix, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            floodFill(matrix, 0, j, pacific);
            floodFill(matrix, m - 1, j, atlantic);
        }

        // 遍历查找都是1的位置
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
        // 标记0为1
        mark[i][j] = 1;
        // 遍历四个方向
        for (int[] direction : directions) {
            int di = i + direction[0];
            int dj = j + direction[1];
            if (inArea(matrix, i, j, di, dj, mark)) {
                floodFill(matrix, di, dj, mark);
            }
        }
    }

    private boolean inArea(int[][] matrix, int i, int j, int di, int dj, int[][] mark) {
        // 更新方向后的位置不在matrix中
        if (di < 0 || di >= m || dj < 0 || dj >= n) {
            return false;
        }
        // 已经走过
        if (mark[di][dj] == 1) {
            return false;
        }
        // 更新之后的值>=才行
        if (matrix[di][dj] < matrix[i][j]) {
            return false;
        }
        return true;
    }
}
