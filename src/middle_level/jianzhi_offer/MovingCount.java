package middle_level.jianzhi_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k?<= 20
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/10 12:30 下午
 */
public class MovingCount {
    /**
     * BFS
     * 记录下机器人能达到的格子
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        // 设置四个方向
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        // 定义队列 将初始(0,0)放进去
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        // 用visited数组来表示访问过的格子
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int result = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                int value = solve(x) + solve(y);
                if (value > k || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
                result++;
            }
        }
        return result;
    }

    /**
     * 计算数位和
     * @param num
     * @return
     */
    private int solve(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
