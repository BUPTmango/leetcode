package middle_level;

/**
 * 《玩转算法面试视频例题》动态规划 背包问题
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号?+?和?-。对于数组中的任意一个整数，你都可以从?+?或?-中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * 注意:
 * <p>
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/5/8 2:50 下午
 */
public class FindTargetSumWays {
    /**
     * 枚举  不推荐 太慢
     * 执行用时：
     * 728 ms
     * , 在所有 Java 提交中击败了
     * 8.02%
     * 的用户
     * 可以将它添加 + 或 -，递归地搜索这两种情况
     *
     * @param nums
     * @param S
     * @return
     */
    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
            return;
        }
        calculate(nums, i + 1, sum + nums[i], S);
        calculate(nums, i + 1, sum - nums[i], S);
    }


    /**
     * 动态规划
     * 把所有符号为正的数总和设为一个背包的容量，容量为x；
     * 把所有符号为负的数总和设为一个背包的容量，容量为y。
     * 在给定的数组中，有多少种选择方法让背包装满。
     * 令sum为数组的总和，则x+y = sum。而两个背包的差为S,则x-y=S。从而求得x=(S+sum)/2。
     * 基于上述分析，题目转换为背包问题：给定一个数组和一个容量为x的背包，求有多少种方式让背包装满。
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays_dp(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // 背包容量为整数，sum+S为奇数的话不满足要求
        if ((sum + S) % 2 == 1) {
            return 0;
        }
        // 目标和不可能大于总和
        if (S > sum) {
            return 0;
        }
        int len = (sum + S) / 2;
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = len; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[len];
    }
}
