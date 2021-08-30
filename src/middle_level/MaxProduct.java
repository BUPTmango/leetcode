package middle_level;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums?，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:?子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:?结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/7 12:01 下午
 */
public class MaxProduct {
    /**
     * 当 nums[i] >= 0 并且dpMax[i-1] > 0，dpMax[i] = dpMax[i-1] * nums[i]
     * 当 nums[i] >= 0 并且dpMax[i-1] < 0，此时如果和前边的数累乘的话，会变成负数，所以dpMax[i] = nums[i]
     * 当 nums[i] < 0，此时如果前边累乘结果是一个很大的负数，和当前负数累乘的话就会变成一个更大的数。所以我们还需要一个数组 dpMin 来记录以第 i 个元素的结尾的子数组，乘积最小的值。
     *   当dpMin[i-1] < 0，dpMax[i] = dpMin[i-1] * nums[i]
     *   当dpMin[i-1] >= 0，dpMax[i] = nums[i]
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            // nums[i]<0的一种情况 + >0的两种情况（考虑dpMax的正负）
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            // nums[i]>0的一种情况 + <0的两种情况（考虑dpMax的正负）
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }
}
