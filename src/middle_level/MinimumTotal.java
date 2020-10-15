package middle_level;

import java.util.List;

/**
 * 《玩转算法面试视频例题》动态规划
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/15 7:19 下午
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 用 f[i][j] 表示从三角形顶部走到位置 (i, j) 的最小路径和
        int[][] f = new int[n][n];
        // 定义初始值
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            // 每一行最左侧 只有上一行的左侧生效
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            // 比较j和j-1的最小值   注意！！！ 这里是j < i
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            // 每一行最右侧 只有上一行的右侧生效   注意！！！ 这里的索引是i
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        // 找到最后一行中的最小值
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
