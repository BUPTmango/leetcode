package middle_level;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * ����ת�㷨������Ƶ���⡷
 * 215. �����еĵ�K�����Ԫ��
 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [3,2,1,5,6,4] �� k = 2
 * ���: 5
 * ʾ��?2:
 * <p>
 * ����: [3,2,3,1,2,4,5,5,6] �� k = 4
 * ���: 4
 *
 * @author Wang Guolong
 * @version 1.0
 * @date 2020/4/25 12:00 ����
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // Comparator.comparingInt(n -> n)�ȼ���(n1, n2) -> n1 - n2
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        // ���������
        for (int n : nums) {
            heap.add(n);
            // ά����СΪk�Ķ�
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    /**
     * ����ѡ���㷨
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_quick_select(int[] nums, int k) {
        // ���ÿ�������˼��
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
        // ���ѡ��һ��pivot
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
