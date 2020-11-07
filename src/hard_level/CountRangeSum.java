package hard_level;

/**
 * 327. 区间和的个数
 * 给定一个整数数组nums，返回区间和在[lower, upper]之间的个数，包含lower和upper。
 * 区间和S(i, j)表示在nums中，位置从i到j的元素之和，包含i和j(i ≤ j)。
 *
 * 说明:
 * 最直观的算法复杂度是O(n2) ，请在此基础上优化你的算法。
 *
 * 示例:
 *
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/7 12:17 下午
 */
public class CountRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        long low = lower;
        long up = upper;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= low && sum <= up) {
                    res++;
                }
            }
        }
        return res;
    }
}
