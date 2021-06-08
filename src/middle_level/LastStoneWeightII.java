package middle_level;

import java.util.Arrays;

/**
 * 背包问题
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组?stones 表示。其中?stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为?x 和?y，且?x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果?x == y，那么两块石头都会被完全粉碎；
 * 如果?x != y，那么重量为?x?的石头将会完全粉碎，而重量为?y?的石头新重量为?y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：stones = [1,2]
 * 输出：1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/6/8 09:17
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        // 相当于有+有-的石头，要让两者接近，所以也就是-的和要尽可能接近sum/2
        int sum = Arrays.stream(stones).sum();
        // sum / 2 的背包问题
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = m; i >= stone; i--) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }
        for (int j = m; ; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
}
