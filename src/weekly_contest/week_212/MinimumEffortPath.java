package weekly_contest.week_212;

/**
 * 5548. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路劲差值最大值为 3 。
 * 示例 2：
 *
 *
 *
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 *
 *
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 *
 *
 * 提示：
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/25 11:21 上午
 */
public class MinimumEffortPath {
    private int m = 0;
    private int n = 0;
    private int res = Integer.MAX_VALUE;
    private int[][] directions = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
//    private boolean[][] visited;
//    public int minimumEffortPath(int[][] heights) {
//        m = heights.length;
//        n = heights[0].length;
//        visited = new boolean[m][n];
//        backtrack(heights, 0, 0, 0);
//        return res;
//    }
//
//    private void backtrack(int[][] heights, int i, int j, int strength) {
//        if (i == m - 1 && j == n - 1) {
//            res = Math.min(res, strength);
//            return;
//        }
//        visited[i][j] = true;
//        for (int[] direction : directions) {
//            int di = i + direction[0];
//            int dj = j + direction[1];
//            if (di >= 0 && dj >= 0 && di < m && dj < n && !visited[di][dj]) {
//                // 注意！！ 这里要使用局部变量
//                int tmpStrength = Math.max(strength, Math.abs(heights[di][dj] - heights[i][j]));
//                backtrack(heights, di, dj, tmpStrength);
//            }
//        }
//        visited[i][j] = false;
//    }


    /**
     * 二分法 通过遍历所有可能的体力来得到结果
     * @param heights
     * @return
     */
    public int minimumEffortPath_better(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int l = 0, r = 1_000_000, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean[][] visited = new boolean[m][n];
            if (dfs(heights, visited, 0, 0, mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean dfs(int[][] heights, boolean[][] visited, int i, int j, int limit) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            int di = i + direction[0];
            int dj = j + direction[1];
            if (di >= 0 && dj >= 0 && di < m && dj < n && !visited[di][dj] && Math.abs(heights[di][dj] - heights[i][j]) <= limit) {
                if (dfs(heights, visited, di, dj, limit)) {
                    return true;
                }
            }
        }
        // 注意！！！ 这里不需要回溯 
        // visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        System.out.println(minimumEffortPath.minimumEffortPath_better(new int[][]{{1,2,1,1,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,
                2,1,2,1}, {1,1,1,2,1}}));
    }
}
