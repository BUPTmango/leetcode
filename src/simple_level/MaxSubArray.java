package simple_level;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author mango
 * @create 2019-03-12 9:46 AM
 */
public class MaxSubArray {
    /**
     * O(n2)的复杂做法
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum > max) {
                max = sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 动态规划 推荐
     * 定义状态：
     * dp[i] ： 表示以 nums[i] 结尾的连续子数组的最大和
     *
     * 状态转移方程：
     * dp[i] = max{num[i],dp[i-1] + num[i]}
     * @param nums
     * @return
     */
    public static int new_maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;
        // 注意这里从1开始
        for (int i = 1; i < nums.length; i++) {
            // 考虑两种情况 作为一个新段还是加入原来的段
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;
            // 取最大结果
            res = Math.max(res, dp_1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new_maxSubArray(new int[]{-2,1}));
    }
}