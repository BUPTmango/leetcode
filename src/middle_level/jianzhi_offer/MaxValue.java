package middle_level.jianzhi_offer;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ? [1,3,1],
 * ? [1,5,1],
 * ? [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/7/6 3:08 下午
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 从左上角开始
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 如果左上角 跳过
                if(i == 0 && j == 0) continue;
                // 如果是第一行 肯定是由上一个向右得到
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                // 如果是第一列 肯定由上一个向下得到
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                // 其余取向右和向下的最大值
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        // 返回右下角的元素
        return grid[m - 1][n - 1];
    }
}
