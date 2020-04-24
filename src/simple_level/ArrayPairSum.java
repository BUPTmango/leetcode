package simple_level;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 * 给定长度为?2n?的数组, 你的任务是将这些数分成?n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到?n 的 min(ai, bi) 总和最大。
 *
 * 示例 1:
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 *
 * n?是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/24 10:09 下午
 */
public class ArrayPairSum {
    /**
     * 我们可以对给定数组的元素进行排序，并直接按排序顺序形成元素的配对。
     * 这将导致元素的配对，它们之间的差异最小，从而导致所需总和的最大化。
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int sum = 0;
        // 两个一组 选每组第一个
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
