package interview.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/15 12:49 下午
 */
public class QuickSort {

    private int count = 0;

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(nums, start, end);
        sort(nums, start, end - 1);
        sort(nums, start + 1, end);
    }

    private int partition(int[] nums, int left, int right) {
        count++;
        // 随机选一个作为pivot
        if (right > left) {
            int random = (int) (Math.random() * (right - left) + left + 1);
            int tmp = nums[left];
            nums[left] = nums[random];
            nums[random] = tmp;
        }
        int pivot = nums[left];
        System.out.println();
        System.out.println("准备开始partition : " + Arrays.toString(nums));
        System.out.println("选中的pivot是 : " + pivot);
        while (left < right) {
            // nums[right] >= pivot 注意！！！！ 这里要有= 否则数组中有重复数字的时候会发生死循环
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        System.out.println("进行最后交换前 : " + Arrays.toString(nums));
        nums[left] = pivot;
        System.out.println("partition结束 : " + Arrays.toString(nums));
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{1,2,3,4,5,6,7,8};
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("一共进行了 " + quickSort.count + " 次partition.");
    }
}
