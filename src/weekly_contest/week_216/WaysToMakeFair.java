package weekly_contest.week_216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 5607. 生成平衡数组的方案数
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 *
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 *
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 *
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 *
 * 示例 1：
 *
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/11/22 11:02 上午
 */
public class WaysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int length = nums.length;
        // 前缀和 奇数在前 偶数在后
        int[][] front = new int[length][2];
        for (int i = 1; i < length; i++) {
            int preOdd = front[i - 1][0];
            int preEven = front[i - 1][1];
            if (i % 2 == 0) {
                preOdd += nums[i - 1];
            } else {
                preEven += nums[i - 1];
            }
            front[i][0] = preOdd;
            front[i][1] = preEven;
        }

        // 后缀和
        int[][] back = new int[length][2];
        for (int i = length - 2; i >= 0; i--) {
            int preOdd = back[i + 1][0];
            int preEven = back[i + 1][1];
            if (i % 2 == 0) {
                preOdd += nums[i + 1];
            } else {
                preEven += nums[i + 1];
            }
            back[i][0] = preOdd;
            back[i][1] = preEven;
        }

        int res = 0;
        // 后缀翻转相加
        for (int i = 0; i < length; i++) {
            int odd = front[i][0] + back[i][1];
            int even = front[i][1] + back[i][0];
            if (odd == even) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        WaysToMakeFair fair = new WaysToMakeFair();
        System.out.println(fair.waysToMakeFair(new int[]{1,1,1}));
    }
}
