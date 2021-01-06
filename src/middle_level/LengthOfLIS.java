package middle_level;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 《玩转算法面试视频例题》动态规划 最长上升子序列
 * 300. 最长递增子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是?[2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为?O(n2) 。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/6 1:34 下午
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[i]表示以nums[i]为结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果前面的数比当前的小 就考虑更新当前个数为小的数的个数加一
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = 1;
        // 注意！！！ 这里不是返回最后一个元素 而是要遍历寻找
        // 查找dp中以所有位置结尾的里面最长的序列
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
