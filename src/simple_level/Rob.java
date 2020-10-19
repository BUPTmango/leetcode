package simple_level;

import java.util.Arrays;

/**
 * 《玩转算法面试视频例题》 动态规划 状态的定义 状态的转移
 * 198 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * ?    偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * ?    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/2/16 12:16 下午
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // 初始化 在[n - 1, n)范围里 只有一家 必偷
        dp[n - 1] = nums[n - 1];
        // 尝试在[i, n)范围内打家劫舍
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // j + 2 要考虑越界问题
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < n ? dp[j + 2] : 0));
            }
        }
        return dp[0];
    }
}
