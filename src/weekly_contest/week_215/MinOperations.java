package weekly_contest.week_215;

import java.util.Arrays;

/**
 * 5602. 将 x 减到 0 的最小操作数 显示英文描述
 * 通过的用户数462
 * 尝试过的用户数1051
 * 用户总通过次数463
 * 用户总提交次数2276
 * 题目难度Medium
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 *
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 *
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/15 11:22 上午
 */
public class MinOperations {
    private int res;
    private boolean[][] visited;
    public int minOperations(int[] nums, int x) {
        res = nums.length + 1;
        // 超出内存限制 不加visited超出时间限制
        visited = new boolean[nums.length][nums.length];
        int left = 0, right = nums.length - 1;
        backtrack(nums, left, right, x, 0);
        if (res == nums.length + 1) {
            res = -1;
        }
        return res;
    }

    private void backtrack(int[] nums, int left, int right, int x, int count) {
        if (left < 0 || right >= nums.length || left > right || x < 0 || visited[left][right]) {
            return;
        }
        if (x == 0) {
            res = Math.min(res, count);
            return;
        }
        if (left == right) {
            if (x == nums[left]) {
                res = Math.min(res, count + 1);
            }
            return;
        }
        visited[left][right] = true;
        backtrack(nums, left + 1, right, x - nums[left], count + 1);
        backtrack(nums, left, right - 1, x - nums[right], count + 1);
    }

    public static void main(String[] args) {
        MinOperations min = new MinOperations();
        int[] nums = new int[]{3,2,20,1,1,3};
        int x = 10;
        System.out.println(min.minOperations(nums, x));
    }
}
