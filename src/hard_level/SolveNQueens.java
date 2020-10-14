package hard_level;

import java.util.*;

/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 二维平面
 * 51. N 皇后
 * n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的n皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/14 10:31 上午
 */
public class SolveNQueens {

    private boolean[] column;
    private boolean[] diagonal1;
    private boolean[] diagonal2;
    private List<Integer> rowRes = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        // 不能出现在同一列
        column = new boolean[n];
        // 不能出现在同一个正向对角线
        diagonal1 = new boolean[2 * n - 1];
        // 不能出现在同一个反向对角线
        diagonal2 = new boolean[2 * n - 1];
        putQueen(n, 0);
        return res;
    }

    /**
     * 尝试在一个n皇后问题中，摆放第index行的皇后的位置
     * @param n
     * @param index
     */
    private void putQueen(int n, int index) {
        if (index == n) {
            res.add(generateBoard(n, new ArrayList<>(rowRes)));
        }

        for (int i = 0; i < n; i ++) {
            // 尝试将index行的皇后摆在第i列
            if (!column[i] && !diagonal1[index + i] && !diagonal2[index - i + (n - 1)]) {
                rowRes.add(i);
                column[i] = true;
                diagonal1[index + i] = true;
                diagonal2[index - i + (n - 1)] = true;
                putQueen(n, index + 1);
                // 回溯
                rowRes.remove(rowRes.size() - 1);
                column[i] = false;
                diagonal1[index + i] = false;
                diagonal2[index - i + (n - 1)] = false;
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> positions) {
        List<String> board = new ArrayList<>();
        char[] rowChar = new char[n];
        positions.forEach(pos -> {
            Arrays.fill(rowChar, '.');
            rowChar[pos] = 'Q';
            board.add(new String(rowChar));
        });
        return board;
    }
}
