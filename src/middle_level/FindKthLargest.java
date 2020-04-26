package middle_level;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
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
}
