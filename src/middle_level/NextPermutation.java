package middle_level;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/8 12:38 下午
 */
public class NextPermutation {
    /**
     * https://www.bilibili.com/video/BV1N4411V7Yw?from=search&seid=988948089204799977
     * 算法描述：
     * 从右向左找第一个前面比后面小的数
     * 再从右向左找第一个比刚找到那个数大的数
     * 两个数交换
     * 之后把后面的所有数调换顺序
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 从后往前找到不是最大的序列
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            // 从右往左找到比当前这个数字大的数
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 将后面的数全部调换顺序
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int low, int high) {
        while (low < high) {
            swap(nums, low++, high--);
        }
    }
}
