package middle_level;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 二维平面
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含'X'和'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/13 8:44 下午
 */
public class Solve {
    private int m;
    private int n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        // 找到边界上的O 开始遍历 标记为A
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        // A的标记为O O的标记为X
        for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
                if (board[p][q] == 'A') {
                    board[p][q] = 'O';
                } else if (board[p][q] == 'O') {
                    board[p][q] = 'X';
                }
            }
        }
    }

    /**
     * 标记边上的O为A
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        // 标记O为A
        board[i][j] = 'A';
        // 继续遍历四个方向
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
