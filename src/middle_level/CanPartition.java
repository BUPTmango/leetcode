package middle_level;

/**
 * 《玩转算法面试视频例题》动态规划 背包问题
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例?2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/10/11 5:57 下午
 */
public class CanPartition {
    /**
     * 典型的背包问题 在n个物品中选出一定物品填满sum/2的背包
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if (sum % 2 != 0) {
            return false;
        }

        int capacity = sum / 2;
        boolean[] dp = new boolean[capacity + 1];

        for (int i = 0; i <= capacity; i++) {
            // 初始化只考虑nums[0]这一个元素的时候，要是正好这一个元素就装满了背包，就为true，否则为false
            dp[i] = (nums[0] == i);
        }

        // 考虑nums[i]元素 在背包j容量下的情况
        for (int i = 1; i < len; i++) {
            for (int j = capacity; j >= nums[i]; j--) {
                // 考虑不使用和使用新添加的nums[i]元素两种情况
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[capacity];
    }
}
