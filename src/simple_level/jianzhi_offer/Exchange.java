package simple_level.jianzhi_offer;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums =?[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/4 10:26 上午
 */
public class Exchange {
    /**
     * 快慢双指针
     *
     * 定义快慢双指针 fast 和 low ，fast 在前， low 在后 .
     * fast 的作用是向前搜索奇数位置，low 的作用是指向下一个奇数应当存放的位置
     * fast 向前移动，当它搜索到奇数时，将它和 nums[low] 交换，此时 low 向前移动一个位置 .
     * 重复上述操作，直到 fast 指向数组末尾 .
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int fast = 0, slow = 0;
        // fast向前搜索奇数位置
        while (fast < nums.length) {
            // 搜索到奇数
            if (nums[fast] % 2 != 0) {
                // fast位置和slow位置交换
                nums = swap(nums, fast, slow);
                // slow向前移动一个位置 slow是下一个奇数应该存放的位置
                slow++;
            }
            // fast向前移动
            fast++;
        }
        return nums;
    }

    private int[] swap(int[] nums, int i, int j) {
        int middle = nums[i];
        nums[i] = nums[j];
        nums[j] = middle;
        return nums;
    }
}
