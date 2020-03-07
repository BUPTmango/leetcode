package simple_level.jianzhi_offer;

/**
 * 面试题42. 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:?连续子数组?[4,-1,2,1] 的和最大，为?6。
 *
 * 提示：
 *
 * 1 <=?arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/7 9:01 上午
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i] + dp[i - 1] ? nums[i] : nums[i] + dp[i - 1];
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
