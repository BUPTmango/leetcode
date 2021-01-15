package interview.sort;

import java.util.Arrays;

/**
 * ��������
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2021/1/15 12:49 ����
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
        int pivot = nums[left];
        System.out.println();
        System.out.println("׼����ʼpartition : " + Arrays.toString(nums));
        System.out.println("ѡ�е�pivot�� : " + pivot);
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        System.out.println("������󽻻�ǰ : " + Arrays.toString(nums));
        nums[left] = pivot;
        System.out.println("partition���� : " + Arrays.toString(nums));
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{4, 2, 5, 9, 1, 3, 7, 8, 6};
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("һ�������� " + quickSort.count + " ��partition.");
    }
}
