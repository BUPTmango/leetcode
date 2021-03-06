package simple_level.jianzhi_offer;

/**
 * 面试题60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例?2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * ?
 * 限制：
 * <p>
 * 1 <= n <= 11
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/10 9:40 上午
 */
public class GetNSum {
    /**
     * 动态规划
     * 单单看第 n 枚骰子，它的点数可能为 1,2,3,...,6 ，
     * 因此投掷完 n 枚骰子后点数 j 出现的次数，
     * 可以由投掷完 n-1 枚骰子后，对应点数 j-1, j-2, j-3, ... , j-6 出现的次数之和转化过来。
     * <p>
     * for (第n枚骰子的点数 i = 1; i <= 6; i ++) {
     * dp[n][j] += dp[n-1][j - i]
     * }
     * <p>
     * <p>
     * 我们可以直接知道的状态是啥，就是第一阶段的状态：
     * 投掷完 1 枚骰子后，它的可能点数分别为 1,2,3,...,6 ，并且每个点数出现的次数都是 1 .
     * <p>
     * for (int i = 1; i <= 6; i ++) {
     * dp[1][i] = 1;
     * }
     * <p>
     * 用一维数组来保存一个阶段的状态，然后对下一个阶段可能出现的点数 j 从大到小遍历，实现一个阶段到下一阶段的转换。
     *
     * @param n
     * @return
     */
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        // 边界条件
        for (int s = 1; s <= 6; s++) {
            dp[1][s] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                // 求dp[i][s]
                for (int d = 1; d <= 6; d++) {
                    // s - d 是凑出来的最小的情况
                    if (s - d < i - 1) {
                        break;// 为0了
                    }
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double total = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }
}
