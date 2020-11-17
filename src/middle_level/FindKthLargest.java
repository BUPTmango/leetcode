package middle_level;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 《玩转算法面试视频例题》
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例?2:
 *
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
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_quick_select(int[] nums, int k) {
        // 首先随机打乱数组
        shuffle(nums);
        int lo = 0, hi = nums.length - 1;
        // 索引转化 转换成升序的第k索引
        k = nums.length - k;
        while (lo <= hi) {
            // 在 nums[lo..hi] 中选一个分界点
            int p = partition(nums, lo, hi);
            if (p < k) {
                // 第 k 大的元素在 nums[p+1..hi] 中
                lo = p + 1;
            } else if (p > k) {
                // 第 k 大的元素在 nums[lo..p-1] 中
                hi = p - 1;
            } else {
                // 找到第 k 大元素
                return nums[p];
            }
        }
        return -1;
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        // 默认将nums[lo]作为默认分界点 pivot
        int pivot = nums[lo];
        // j = hi + 1 因为while会先执行 --
        int i = lo, j = hi + 1;
        while (true) {
            // 保证 nums[lo...i] 都小于 pivot
            while (nums[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            // 保证 nums[j...hi] 都大于 pivot
            while (nums[--j] > pivot) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            // 保证 nums[lo...i] < pivot < nums[j...hi]
            swap(nums, i, j);
        }
        // 将pivot交换到正确的位置
        swap(nums, j, lo);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
