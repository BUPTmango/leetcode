package middle_level;

import hard_level.Solution;

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

    /**
     * 贪心 + 二分查找
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_better(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            // 如果 nums[i] > d[len] ，则直接加入到 d 数组末尾，并更新len=len+1；
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            // 否则，在 d 数组中二分查找，找到第一个比 nums[i] 小的数 d[k] ，并更新 d[k+1]=nums[i]。
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
