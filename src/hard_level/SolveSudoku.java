package hard_level;

/**
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 空白格用'.'表示。
 *
 * 一个数独。
 *
 * 答案被标成红色。
 *
 * 提示：
 *
 * 给定的数独序列只包含数字1-9和字符'.'。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是9x9形式的。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/24 10:38 下午
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // 找到一个可行解，触发base case
            return true;
        }

        if (board[i][j] != '.') {
            // 如果有预设数字， 不用穷举
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            // 如果找到一个可行解 立即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // 穷举完1-9，依然没有找到可行解
        // 需要前面的格子换个数字穷举
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) {
                return false;
            }
            // 判断列是否存在重复
            if (board[i][c] == n) {
                return false;
            }
            // 判断 3 * 3 方框是否存在重复
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }
}
