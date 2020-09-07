package middle_level;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s  ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * ?
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/9/7 9:03 上午
 */
public class MinSubArrayLen {
    /**
     * 暴力法
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 双指针
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_two_pointer(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        // 两个指针从头开始走
        int start = 0, end = 0;
        int sum = 0;
        // end指针从头往后走
        while (end < n) {
            sum += nums[end];
            // 如果和大于s了 更新最小数组 sum减去start的值 start指针向后走
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            // 更新end指针
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
