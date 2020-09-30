package middle_level;

import java.util.*;

/**
 * 《玩转算法面试视频例题》队列 图的BFS
 * 279. 完全平方数
 * 给定正整数?n，找到若干个完全平方数（比如?1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例?1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/30 1:58 下午
 */
public class NumSquares {

    /**
     * 标签：动态规划
     * 首先初始化长度为n+1的数组dp，每个位置都为0
     * 如果n为0，则结果为0
     * 对数组进行遍历，下标为i，每次都将当前数字先更新为最大的结果，即dp[i]=i，比如i=4，最坏结果为4=1+1+1+1即为4个数字
     * 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i表示当前数字，j*j表示平方数
     * 时间复杂度：O(n*sqrt(n))，sqrt为平方根
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

    /**
     * 广度优先搜索 BFS
     * 整个问题转化为图论问题
     * 从n到0 每个数字表示一个节点
     * 如果两个数字x和y相差一个完全平方数 则连一条边
     * 这样我们得到了一个无权图
     * 原问题转化成 求这个无权图中从n到0的最短路径
     *
     * 注意处理冗余问题！！！
     *
     * @param n
     * @return
     */
    public int numSquares_BFS(int n) {

        Queue<Integer> queue = new LinkedList<>();
        // 解决冗余问题
        boolean[] visited = new boolean[n + 1];
        int step = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.remove();
                // num - j * j 这里会产生冗余 不像是树只有一个父节点 图有多种方式到达一个节点
                for (int j = 1; num - j * j >= 0; j++) {
                    int remain = num - j * j;
                    if (remain == 0) {
                        return step;
                    } else {
                        if (!visited[remain]) {
                            queue.add(remain);
                            visited[remain] = true;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
