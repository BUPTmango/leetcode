package middle_level;

import java.util.Random;

/**
 * 912. 排序数组
 * 给你一个整数数组?nums，将该数组升序排列。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/3/31 10:45 上午
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        randomized_quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private int randomized_partition(int[] nums, int l, int r) {
        int i = (int)(Math.random() *(r - l + 1)) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private void randomized_quicksort(int[] nums, int l, int r) {
        if (l < r){
            int pos = randomized_partition(nums, l, r);
            randomized_quicksort(nums, l, pos - 1);
            randomized_quicksort(nums, pos + 1, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int middle = nums[i];
        nums[i] = nums[j];
        nums[j] = middle;
    }

    public static void main(String[] args) {
        SortArray sa = new SortArray();
        int[] nums = new int[]{5,2,3,1};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        sa.swap(nums, 0,1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
