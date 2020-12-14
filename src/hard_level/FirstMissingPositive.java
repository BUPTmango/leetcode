package hard_level;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 示例1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/12/14 8:13 下午
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 每次交换会让一个元素到正确的位置上
        for (int i = 0; i < n; ++i) {
            // 注意！！！！ 注意满足条件才交换
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // 找到不满足的加一
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 正常的 直接加一
        return n + 1;
    }
}
