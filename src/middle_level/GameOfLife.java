package middle_level;

/**
 * 289. 生命游戏
 * 根据?百度百科?，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例：
 *
 * 输入：
 * [
 * ? [0,1,0],
 * ? [0,0,1],
 * ? [1,1,1],
 * ? [0,0,0]
 * ]
 * 输出：
 * [
 * ? [0,0,0],
 * ? [1,0,1],
 * ? [0,1,1],
 * ? [0,1,0]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/2 10:45 上午
 */
public class GameOfLife {
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    int[][] board;
    int m, n;
    public void gameOfLife(int[][] board) {
        this.board = board;
        // 特判
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        this.m = board.length;
        this.n = board[0].length;
        // 遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 拿到当前位置周围活细胞数量
                int cnt = countLiveNums(i, j);
                // 1. 活细胞周围八个位置有两个或三个活细胞，下一轮继续活
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) {
                    board[i][j] = 3;
                }
                // 2. 死细胞周围有三个活细胞，下一轮复活了
                if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }

        // 更新结果
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1; // 右移位同时赋给原值
            }
        }
    }

    /**
     * 统计某个细胞周围活细胞的数量
     * @return
     */
    private int countLiveNums(int x, int y) {
        int count = 0;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            count += (board[nx][ny] & 1);
        }
        return count;
    }
}
