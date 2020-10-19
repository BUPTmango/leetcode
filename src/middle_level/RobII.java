package middle_level;

import java.util.Arrays;

/**
 * 《玩转算法面试视频例题》动态规划
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/17 9:14 下午
 */
public class RobII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃
        // 所以变成两个问题 不偷窃第一个房子的问题和不偷窃最后一个房子的问题
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    /**
     * 简化空间复杂度
     * 我们发现 dp[n] 只与 dp[n-1] 和 dp[n-2] 有关系
     * 因此我们可以设两个变量 cur和 pre 交替记录，将空间复杂度降到 O(1)
     * @param nums
     * @return
     */
    private int myRob(int[] nums) {
        int n = nums.length;
        // 分别用dp_i, dp_i_1, dp_i_2表示dp[i], dp[i+1], dp[i+2]
        int dp_i_1 = 0, dp_i_2 = 0, dp_i = -1;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            // 更新位置 向前移动
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
