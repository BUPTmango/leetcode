package hard_level;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. 最大矩形
 *
 * 在84基础上做
 *
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 
 * 提示：
 *
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/26 2:51 下午
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
            // 横轴从第一行向下移动
            max = Math.max(max, maxRec(grid, i));
        }
        return max;
    }

    /** 构造直方图 */
    private void buildHistogram(char[][] matrix, int[][] grid) {
        for (int j = 0; j < matrix[0].length; j++) {
            grid[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 当前位如果为1就++ 如果是0就是0
                grid[i][j] = matrix[i][j] == '1' ? grid[i - 1][j] + 1 : 0;
            }
        }
    }

    /** 同84题 */
    private int maxRec(int[][] grid, int bottom) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 放-1进去 边界情况好处理
        stack.push(-1);
        int curIndex = 0;

        while (curIndex < grid[bottom].length) {
            // 如果不满足递增 就把前面的拿出来算一下max
            while (stack.peek() != -1 && grid[bottom][stack.peek()] >= grid[bottom][curIndex]) {
                max = Math.max(max, grid[bottom][stack.pop()] * (curIndex - stack.peek() - 1));
            }
            stack.push(curIndex++);
        }

        // 剩下的全部是递增的 更新一下max
        while (stack.peek() != -1) {
            max = Math.max(max, grid[bottom][stack.pop()] * (grid[bottom].length - stack.peek() - 1));
        }

        return max;
    }
}
