package middle_level;

/**
 * 《玩转算法面试视频例题》动态规划 背包问题
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i]仅由'0' 和'1' 组成
 * 1 <= m, n <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/20 8:48 上午
 */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = count(strs[i]);
            // 有限背包 注意！！！！ 要从大到小遍历
            for (int j = m; j >= count[0]; j--) {
                for (int k = n; k >= count[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - count[0]][k - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        char[] chars = str.toCharArray();
        int countZero = 0, countOne = 0;
        for (char c : chars) {
            if (c == '0') {
                countZero++;
            }
            if (c == '1') {
                countOne++;
            }
        }
        return new int[]{countZero, countOne};
    }
}
