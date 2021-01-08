package simple_level.jianzhi_offer;


/**
 * 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * ?
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤?输入数组的大小。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/12 10:23 上午
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int length = nums.length - k + 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] result = msw.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int num : result) {
            System.out.println(" " + num);
        }
    }
}

