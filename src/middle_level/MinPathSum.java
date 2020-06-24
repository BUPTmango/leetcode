package middle_level;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m?x?n?网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 * ? [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/6/24 5:14 下午
 */
public class MinPathSum {
    /**
     * 题目要求，只能向右或向下走，换句话说，当前单元格 (i,j)(i,j) 只能从左方单元格 (i-1,j)(i?1,j) 或上方单元格 (i,j-1)(i,j?1) 走到，因此只需要考虑矩阵左边界和上边界。
     *
     * 走到当前单元格 (i,j)(i,j) 的最小路径和 == “从左方单元格 (i-1,j)(i?1,j) 与 从上方单元格 (i,j-1)(i,j?1) 走来的 两个最小路径和中较小的 ” ++ 当前单元格值 grid[i][j]grid[i][j] 。具体分为以下 4 种情况：
     * 当左边和上边都不是矩阵边界时： 即当i \not= 0i
     * ?
     *  =0, j \not= 0j
     * ?
     *  =0时，dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]dp[i][j]=min(dp[i?1][j],dp[i][j?1])+grid[i][j] ；
     * 当只有左边是矩阵边界时： 只能从上面来，即当i = 0, j \not= 0i=0,j
     * ?
     *  =0时， dp[i][j] = dp[i][j - 1] + grid[i][j]dp[i][j]=dp[i][j?1]+grid[i][j] ；
     * 当只有上边是矩阵边界时： 只能从左面来，即当i \not= 0, j = 0i
     * ?
     *  =0,j=0时， dp[i][j] = dp[i - 1][j] + grid[i][j]dp[i][j]=dp[i?1][j]+grid[i][j] ；
     * 当左边和上边都是矩阵边界时： 即当i = 0, j = 0i=0,j=0时，其实就是起点， dp[i][j] = grid[i][j]dp[i][j]=grid[i][j]；
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // 是左边界和上边界 也就是起点 直接跳过
                if(i == 0 && j == 0) continue;
                // 上边界 只能由向右走得到
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                // 左边界 只能由向下走得到
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                // 不是边界 由向右或者向下中的最小值得到
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        // 返回右下角的值 就是最短路径
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
