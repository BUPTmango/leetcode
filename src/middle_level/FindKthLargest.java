package middle_level;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 《玩转算法面试视频例题》
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例?2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/25 12:00 下午
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // Comparator.comparingInt(n -> n)等价于(n1, n2) -> n1 - n2
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        // 将数组入堆
        for (int n : nums) {
            heap.add(n);
            // 维护大小为k的堆
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * 快速选择算法
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_quick_select(int[] nums, int k) {
        // 利用快速排序思想
        int left = 0, right = nums.length - 1;
        k = nums.length - k;
        while (left < right) {
            int index = partition(nums, left, right);
            if (index == k) {
                break;
            } else if (index > k) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] arr, int low, int high) {
        // 随机选择一个pivot
        if (high > low) {
            int idx = (int) (low + 1 + Math.random() * (high - low));
            int tmp = arr[idx];
            arr[idx] = arr[low];
            arr[low] = tmp;
        }

        int pivotKey = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivotKey) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivotKey) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivotKey;
        return low;
    }
}
