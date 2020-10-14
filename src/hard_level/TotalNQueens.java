package hard_level;


/**
 * 《玩转算法面试视频例题》 树形问题 回溯算法 二维平面
 * 52. N皇后 II
 * n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..", // 解法 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 * ["..Q.", // 解法 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/14 11:45 上午
 */
public class TotalNQueens {
    private boolean[] column;
    private boolean[] diagonal1;
    private boolean[] diagonal2;
    private int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        // 不能出现在同一列
        column = new boolean[n];
        // 不能出现在同一个正向对角线
        diagonal1 = new boolean[2 * n - 1];
        // 不能出现在同一个反向对角线
        diagonal2 = new boolean[2 * n - 1];
        putQueen(n, 0);
        return count;
    }

    /**
     * 尝试在一个n皇后问题中，摆放第index行的皇后的位置
     * @param n
     * @param index
     */
    private void putQueen(int n, int index) {
        if (index == n) {
            count++;
        }

        for (int i = 0; i < n; i ++) {
            // 尝试将index行的皇后摆在第i列
            if (!column[i] && !diagonal1[index + i] && !diagonal2[index - i + (n - 1)]) {
                column[i] = true;
                diagonal1[index + i] = true;
                diagonal2[index - i + (n - 1)] = true;
                putQueen(n, index + 1);
                // 回溯
                column[i] = false;
                diagonal1[index + i] = false;
                diagonal2[index - i + (n - 1)] = false;
            }
        }
    }
}
