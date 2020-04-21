package middle_level;

/**
 * 1248. 统计「优美子数组」
 * 给你一个整数数组?nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * ?
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/21 2:37 下午
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length, res = 0, feed = 0, arr[] = new int[len + 2];
        // 构建arr数组存储1的索引
        for (int i = 0; i < len; i++) {
            if (nums[i] % 2 == 1) {
                arr[++feed] = i;
            }
        }
        // 第一位为-1
        arr[0] = -1;
        // 最后一位为总长度
        arr[feed + 1] = len;
        // 查看左右有没有能添加的偶数，可能数相乘
        for (int i = 1; i + k < feed + 2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }
}
